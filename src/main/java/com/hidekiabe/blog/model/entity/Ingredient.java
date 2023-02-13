package com.hidekiabe.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "ingredient")
public class Ingredient implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory!")
    private String name;

    @Column(name = "calories")
    @NotNull(message = "Calories is mandatory!")
    private Integer calories;

    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recipe> recipes;


}
