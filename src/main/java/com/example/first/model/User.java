package com.example.first.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "password must be minimum 6 characters")
    @Column (name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

}

