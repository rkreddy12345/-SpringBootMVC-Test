package com.bootmvc.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Employee_Details")
@Data
@SQLDelete (sql="UPDATE Employee_Details SET STATUS = 'INACTIVE' WHERE id = ?"  )
@Where ( clause = "STATUS='ACTIVE'" )
public class Employee {
    @Id
    @SequenceGenerator ( name ="empSeqGen", sequenceName = "empSequence", initialValue=1001, allocationSize = 1)
    @GeneratedValue(generator ="empSeqGen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String designation;
    private String deptNo;
    private float salary;
    private String status;
}
