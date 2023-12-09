package ru.denisov.AlmazFactory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Ranks")
@Getter
@Setter
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double salary;
}
