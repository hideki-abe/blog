package com.hidekiabe.blog.service;

import com.hidekiabe.blog.model.entity.Ingredient;

import java.util.List;

public interface IngredientServiceInterface {

    Ingredient save(Ingredient ingredient);

    Ingredient update(Ingredient ingredient);

    void delete(Ingredient ingredient);

    List<Ingredient> findAll(Ingredient filter);

}
