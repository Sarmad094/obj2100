package com.example.obj2100.service;

import com.example.obj2100.model.User;

import java.util.List;

public interface UserService {

    // Hent bruker ved ID
    User getUserById(Long id);

    // Lagre bruker
    void saveUser(User user);

    // Slett bruker
    void deleteUser(Long id);

    // Hent alle brukere
    List<User> getAllUsers();

    // Hent bruker ved brukernavn
    User getUserByUsername(String username);

    // Hent bruker ved e-post
    User getUserByEmail(String email);
}
