package com.hidekiabe.blog.controller;

import com.hidekiabe.blog.model.Ingredient;
import com.hidekiabe.blog.service.imp.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(value = "calories", required = false) int calories
    ) {
        Ingredient filter = new Ingredient();
        filter.setName(name);
        filter.setCalories(calories);

        List<Ingredient> ingredients = this.service.findAll(filter);
        return ResponseEntity.ok(ingredients);
    }

}
