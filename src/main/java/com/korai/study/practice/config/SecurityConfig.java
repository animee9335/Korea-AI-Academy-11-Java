package com.korai.study.practice.config;

import com.korai.study.practice.entity.User;

public class SecurityConfig {
    private static Integer loginSession = null;

    public static void login(int userId) {
        loginSession = userId;
    }

    public static int getUserId() {
        return loginSession;
    }
}
