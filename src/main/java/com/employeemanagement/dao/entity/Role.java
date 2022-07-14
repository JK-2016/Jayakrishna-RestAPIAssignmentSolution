package com.employeemanagement.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
@ToString(exclude = "user")
@EqualsAndHashCode(exclude = "user")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;
}
