package ru.denisov.AlmazFactory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;

@Entity(name = "storeofmaterials")
@Getter
@Setter
public class Material {
    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_of_material")
    private String name;
    private double count;
}
