package com.example.obj2100.repository;

import com.example.obj2100.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Metode for å hente bruker etter brukernavn
    User findByEmail(String email); // Metode for å hente bruker etter e-post
}
