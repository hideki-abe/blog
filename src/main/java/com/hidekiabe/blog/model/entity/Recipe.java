package com.hidekiabe.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory!")
    @Size(min=4, max=25, message = "Name must be between 4 and 25 characters!")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description is mandatory!")
    @Size(min=20, message = "Description must be at least 20 characters!")
    private String description;

    @Column(name = "date")
    @NotBlank(message = "Date is mandatory!")
    private String date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="recipe_ingredient",
                joinColumns = {@JoinColumn(name="ingredient_id")},
                inverseJoinColumns = {@JoinColumn(name="recipe_id")})
    private List<Ingredient> ingredients;

}
