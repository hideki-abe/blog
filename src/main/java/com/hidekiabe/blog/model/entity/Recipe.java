package com.hidekiabe.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="recipe_ingredient",
                joinColumns = {@JoinColumn(name="ingredient_id")},
                inverseJoinColumns = {@JoinColumn(name="recipe_id")})
    private List<Ingredient> ingredients;

}
