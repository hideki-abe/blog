package com.hidekiabe.blog.service.imp;

import com.hidekiabe.blog.model.entity.Ingredient;
import com.hidekiabe.blog.model.entity.Recipe;
import com.hidekiabe.blog.repository.RecipeRepository;
import com.hidekiabe.blog.service.RecipeServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService implements RecipeServiceInterface {

    private RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Recipe save(Recipe recipe) {
        return this.repository.save(recipe);
    }

    @Override
    @Transactional
    public Recipe update(Recipe recipe) {
        Objects.requireNonNull(recipe.getId());
        return repository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        Objects.requireNonNull(recipe.getId());
        repository.delete(recipe);
    }

    @Override
    public List<Recipe> findAll(Recipe filter) {
        Example example = Example.of(filter, ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return this.repository.findAll(example);
    }

    public Optional<Recipe> findById(Integer id) {
        return this.repository.findById(id);
    }

}
