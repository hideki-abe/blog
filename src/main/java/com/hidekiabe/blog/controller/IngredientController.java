package com.hidekiabe.blog.controller;

import com.hidekiabe.blog.model.dto.IngredientDTO;
import com.hidekiabe.blog.model.entity.Ingredient;
import com.hidekiabe.blog.service.imp.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/ingredients")
public class IngredientController {

    private IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity findAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "calories", required = false) Integer calories
    ) {
        Ingredient filter = new Ingredient();
        filter.setName(name);
        filter.setCalories(calories);

        List<Ingredient> ingredients = this.service.findAll(filter);
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Ingredient ingredient) {
        try {
            Ingredient entity = this.service.save(ingredient);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody IngredientDTO ingredientDTO) {
        return service.findById(id).map( entity -> {
           try {
               Ingredient ingredient = toEntity(ingredientDTO);
               ingredient.setId(entity.getId());
               service.update(ingredient);
               return ResponseEntity.ok(ingredient);
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
                new ResponseEntity("Ingrediente nâo encontrado!", HttpStatus.BAD_REQUEST));
    }

    private Ingredient toEntity(IngredientDTO dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setCalories(dto.getCalories());
        return ingredient;
    }

}
