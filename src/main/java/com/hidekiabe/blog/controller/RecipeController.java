package com.hidekiabe.blog.controller;

import com.hidekiabe.blog.model.dto.RecipeDTO;
import com.hidekiabe.blog.model.entity.Recipe;
import com.hidekiabe.blog.service.imp.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/recipes")
public class RecipeController {

    private RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity findAll(
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "date", required = false) String date
    ) {
        Recipe filter = new Recipe();
        filter.setDescription(description);
        filter.setDate(date);

        List<Recipe> recipes = this.service.findAll(filter);
        return ResponseEntity.ok(recipes);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Recipe recipe) {
        try {
            Recipe entity = this.service.save(recipe);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody RecipeDTO recipeDTO) {
        return service.findById(id).map( entity -> {
            try {
                Recipe recipe = toEntity(recipeDTO);
                recipe.setId(entity.getId());
                service.update(recipe);
                return ResponseEntity.ok(recipe);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }).orElseGet( () ->
                new ResponseEntity("Ingrediente nâo encontrado!", HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return service.findById(id).map( entity -> {
            this.service.delete(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet( () ->
                new ResponseEntity("Receita não encontrada!", HttpStatus.BAD_REQUEST));
    }

    private Recipe toEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setDescription(dto.getDescription());
        recipe.setDate(dto.getDate());
        return recipe;
    }

}
