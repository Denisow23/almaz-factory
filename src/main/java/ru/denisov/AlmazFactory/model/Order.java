package ru.denisov.AlmazFactory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;
import ru.denisov.AlmazFactory.model.enums.StateOfOrder;

import java.util.Date;

@Entity(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "state_of_order")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Basic(optional=false)
    private StateOfOrder stateOfOrder;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfOrder;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product")
    private Product product;

    private int count;

    @Column(name = "count_left")
    @Generated
    private int countLeft;

}
