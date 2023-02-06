package com.hidekiabe.blog.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "recipe")
public class Recipe {

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recipe")
    private List<Ingredient> ingredients;

}
