package com.github.bruce_mig.aspect_oriented_programming.serviceImpl;

import com.github.bruce_mig.aspect_oriented_programming.annotations.SensitiveMethod;
import com.github.bruce_mig.aspect_oriented_programming.model.User;
import com.github.bruce_mig.aspect_oriented_programming.repository.UserRepository;
import com.github.bruce_mig.aspect_oriented_programming.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    @SensitiveMethod
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUser(User user,Integer id) {
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found!");
        }
        return repository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findByName(String keyword) {
        return repository.findAllByNameContains(keyword);
    }

    @Override
    public List<User> findByAge(Integer age) {
        return repository.findByAge(age);
    }
}
