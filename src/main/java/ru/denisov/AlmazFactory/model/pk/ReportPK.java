package ru.denisov.AlmazFactory.model.pk;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.springframework.format.annotation.DateTimeFormat;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Product;

import java.util.Date;

@Embeddable
@Getter
@Setter
public class ReportPK {

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_report")
    @Generated
    private Date date;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product")
    private Product product;
}
