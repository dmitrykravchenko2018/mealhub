package com.github.dmitrykravchenko2018.mealhub.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_entity")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
