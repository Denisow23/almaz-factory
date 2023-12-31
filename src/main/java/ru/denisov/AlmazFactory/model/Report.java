package ru.denisov.AlmazFactory.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.denisov.AlmazFactory.model.pk.ReportPK;

@Entity(name = "reportsofproducts")
@Getter
@Setter
public class Report {

    @EmbeddedId
    private ReportPK pk;
    private int count;

    @Column(name = "weight_of_particles")
    private double weightOfParticles;
}
