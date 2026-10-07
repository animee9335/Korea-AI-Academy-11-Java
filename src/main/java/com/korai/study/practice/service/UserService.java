package com.korai.study.practice.service;

import com.korai.study.practice.entity.User;
import com.korai.study.practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if ( user == null ) {
            return null;
        }
        if ( !Objects.equals(user.getPassword(), password) ) {
            return null;
        }
        return user;
    }
}
