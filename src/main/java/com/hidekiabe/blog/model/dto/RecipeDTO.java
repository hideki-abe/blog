package com.hidekiabe.blog.model.dto;

import com.hidekiabe.blog.model.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {

    private Integer id;
    private String name;
    private String description;
    private String date;
    private List<Ingredient> ingredients;
}
