package com.github.bruce_mig.aspect_oriented_programming.controller;

import com.github.bruce_mig.aspect_oriented_programming.model.User;
import com.github.bruce_mig.aspect_oriented_programming.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.findAllUsers();
        return !users.isEmpty() ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = service.getUser(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User savedUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
        User updatedUser = service.updateUser(user, id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("filter/{keyword}")
    public ResponseEntity<List<User>> findByName(@PathVariable String keyword) {
        List<User> users = service.findByName(keyword);
        return !users.isEmpty() ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
    }

    @GetMapping("filter/age/{age}")
    public ResponseEntity<List<User>>  findByAge(@PathVariable Integer age) {
        List<User> users = service.findByAge(age);
        return !users.isEmpty() ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
    }
}
