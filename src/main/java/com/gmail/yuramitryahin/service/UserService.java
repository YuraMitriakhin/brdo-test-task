package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.entity.User;
import com.gmail.yuramitryahin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveAll(List<User> users){
        userRepository.saveAll(users);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
