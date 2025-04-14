package com.example.obj2100.service;

import com.example.obj2100.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    User getUserByEmail(String email);
}
