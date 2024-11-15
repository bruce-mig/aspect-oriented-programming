package com.github.bruce_mig.aspect_oriented_programming.service;


import com.github.bruce_mig.aspect_oriented_programming.annotations.SensitiveMethod;
import com.github.bruce_mig.aspect_oriented_programming.model.User;

import java.util.List;

public interface UserService {

    @SensitiveMethod
    User createUser(User user);

    User getUser(Integer id);

    List<User> findAllUsers();

    User updateUser(User user,Integer id);

    void deleteUser(Integer id);

    List<User> findByName(String name);

    List<User> findByAge(Integer age);
}
