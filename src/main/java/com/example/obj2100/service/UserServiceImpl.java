package com.example.obj2100.service;

import com.example.obj2100.model.User;
import com.example.obj2100.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User saveUser(User user) {
        repository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
