package ru.denisov.AlmazFactory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "storeofproducts")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_of_product")
    private String name;
    private int count;
    @ManyToOne(targetEntity = Material.class)
    @JoinColumn(name = "type_of_material")
    private Material material;
    @Column(name = "count_of_material_per_one")
    private double materialPerOne;
}
