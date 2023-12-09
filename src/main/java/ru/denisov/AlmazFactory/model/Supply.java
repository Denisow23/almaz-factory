package ru.denisov.AlmazFactory.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "supplies")
@Getter
@Setter
public class Supply {

    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_of_supply")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfSupply;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @ManyToOne(targetEntity = Material.class)
    @JoinColumn(name = "material")
    private Material material;

    private double weightOfSupply;

}
