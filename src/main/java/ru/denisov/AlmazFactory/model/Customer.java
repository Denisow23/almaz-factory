package ru.denisov.AlmazFactory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "description_of_customer")
    private String description;
    private String contacts;
    private String email;
}
