package com.hidekiabe.blog.service.imp;

import com.hidekiabe.blog.model.entity.Ingredient;
import com.hidekiabe.blog.repository.IngredientRepository;
import com.hidekiabe.blog.service.IngredientServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class IngredientService implements IngredientServiceInterface {

    private IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        Objects.requireNonNull(ingredient.getId());
        return repository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        Objects.requireNonNull(ingredient.getId());
        repository.delete(ingredient);
    }

    @Override
    public List<Ingredient> findAll(Ingredient filter) {
        Example example = Example.of(filter, ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return this.repository.findAll(example);
    }

    public Optional<Ingredient> findById(Integer id) {
        return this.repository.findById(id);
    }
}
