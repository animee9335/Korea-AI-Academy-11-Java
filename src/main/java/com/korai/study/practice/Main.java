package com.korai.study.practice;

import com.korai.study.practice.repository.UserRepository;
import com.korai.study.practice.service.UserService;
import com.korai.study.practice.view.LoginView;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        LoginView loginView = new LoginView(userService);

        while (true) {
            loginView.show();
        }
    }
}
