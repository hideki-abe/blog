package com.hidekiabe.blog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int calories;


}
