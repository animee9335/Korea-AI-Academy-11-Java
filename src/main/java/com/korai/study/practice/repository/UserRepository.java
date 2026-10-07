package com.korai.study.practice.repository;

import com.korai.study.practice.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {

    private List<User> users;

    public UserRepository() {
        User user1 = new User(1, "test1", "123", "장서현");
        User user2 = new User(2, "test2", "1234", "도라에몽");
        User user3 = new User(3, "test3", "1q2w3e4r!", "퉁퉁이");
        User user4 = new User(4, "test4", "1q2w3e4r!", "비실이");
        users = List.of(user1, user2, user3, user4);
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

}
