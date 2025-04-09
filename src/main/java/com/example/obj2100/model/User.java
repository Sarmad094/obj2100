package com.example.obj2100.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto inc. key
    private Long id;

    @Column(name = "username")
    private String username;

}
