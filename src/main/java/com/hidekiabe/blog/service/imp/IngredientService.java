package com.hidekiabe.blog.service.imp;

import com.hidekiabe.blog.model.Ingredient;
import com.hidekiabe.blog.service.IngredientServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IngredientServiceInterface {

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return null;
    }

    @Override
    public void delete(Ingredient ingredient) {

    }

    @Override
    public List<Ingredient> findAll(Ingredient filter) {
        return null;
    }
}
