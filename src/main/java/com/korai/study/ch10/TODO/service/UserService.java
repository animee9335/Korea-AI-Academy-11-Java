package com.korai.study.ch10.TODO.service;

import com.korai.study.ch10.TODO.config.SecurityConfig;
import com.korai.study.ch10.TODO.entity.User;
import com.korai.study.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    @RequiredArgsConstructor를 사용해 대채할 수 있다.
//    UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public String login(String username, String password) {
        User foundUser = userRepository.findByUsername(username); // 찾은 username의 값을 foundUser에 저장
        if ( foundUser == null) { // 값이 없는 경우, null을 반환
            return null;
        }
        if (!Objects.equals(foundUser.getPassword(), password)) {
            return null; // username은 존재하나 password가 일치하지 않는 경우 null을 반환
        }
        return SecurityConfig.generateSessionToken(foundUser); // 값이 존재하고 password가 일치하는 경우, token을 생성하여 id와 합침
    }
}
