package com.korai.study.ch10.TODO.config;

import com.korai.study.ch10.TODO.entity.User;

import java.util.UUID;

public class SecurityConfig {
    private static String loginSession = null;

    public static String getLoginSession() {
        return loginSession;
    }

    public static void setLoginSession(String loginSession) {
        SecurityConfig.loginSession = loginSession;
    }

    // token 생성
    public static String generateSessionToken(User user) {
        // uuid라는 32자리의 8자리-4자리-4자리-4자리-12자리의 랜덤한 값을 생성, toString으로 문자열로 바꾸고 replaceAll로 문자열 안의 "-"를 공백을 변경
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        int userId = user.getId();
        String token = uuid + "@" + userId;
        return token;
    }

    // token에서 userId만 가져오기
    public static int getUserId() {
        int startIndex = loginSession.indexOf("@") + 1; //indexOf() ()안의 찾는 값이 처음나오는 위치를 알려주는 메소드
        String userIdStr = loginSession.substring(startIndex);  // 문자열로 변환된 토큰을 다시 Integer.parseInt 인트 자료형으로 변경
        return Integer.parseInt(userIdStr);
    }
}
