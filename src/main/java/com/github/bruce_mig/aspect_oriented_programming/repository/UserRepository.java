package com.github.bruce_mig.aspect_oriented_programming.repository;

import com.github.bruce_mig.aspect_oriented_programming.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // using query derivation
    List<User> findAllByNameContains(String keyword);

    List<User> findByAge(@Param("age") Integer age);
}
