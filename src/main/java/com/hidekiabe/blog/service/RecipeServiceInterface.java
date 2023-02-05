package com.hidekiabe.blog.service;

import com.hidekiabe.blog.model.Recipe;
import java.util.List;

public interface RecipeServiceInterface {

    Recipe save(Recipe recipe);

    Recipe update(Recipe recipe);

    void delete(Recipe recipe);

    List<Recipe> findAll(Recipe filter);

}
