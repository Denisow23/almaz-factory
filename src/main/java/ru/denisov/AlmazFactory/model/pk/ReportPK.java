package ru.denisov.AlmazFactory.model.pk;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Product;

import java.util.Date;

@Embeddable
public class ReportPK {

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Generated
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_report")
    private Date date;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product")
    private Product product;
}
