package ru.denisov.AlmazFactory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;
import ru.denisov.AlmazFactory.model.enums.JobTitleOfEmployee;

import java.util.Date;

@Entity(name = "employees")
@Getter
@Setter
public class Employee {

    @Id @Generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullName;

    @JoinColumn(name = "rank")
    @ManyToOne(targetEntity = Rank.class)
    private Rank rank;

    private double salary;

    private Double benefits;

   @JdbcTypeCode(SqlTypes.NAMED_ENUM)
   @Basic(optional=false)
    @Column(name = "job_title")
    private JobTitleOfEmployee jobTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   @Generated
    @Temporal(TemporalType.DATE)
    private Date startWork;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endWork;

    @Column(name = "empl_login")
    private String emplLogin;

    private String password;



}
