package com.korai.study.practice.view;

import com.korai.study.practice.config.SecurityConfig;
import com.korai.study.practice.entity.User;
import com.korai.study.practice.service.UserService;

import java.util.Scanner;

public class LoginView {

    private UserService userService;
    private Scanner scanner;

    public LoginView(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        String username;
        String password;

        System.out.println(" [ 가계부 로그인 ] ");
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();

        User foundUser = userService.login(username, password);
        if (foundUser == null) {
            System.out.println("로그인 정보를 다시 확인하세요.");
            System.out.println("계속 진행하시려면 엔터를 눌러주세요.");
            scanner.nextLine();
            return;
        }
        SecurityConfig.login(foundUser);
        System.out.println("로그인 성공");




    }
}
