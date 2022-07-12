package com.employeemanagement.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String name;
    String department;
}
