package com.korai.study.ch11.parking;

public class FeeCalculator {

    public static int calculate(long minutes, boolean compact) {
        int fee = 2000;

        // 10분 이하 무료
        if (minutes <= 10) {
            return 0;
        }

        // 30분 초과 2000원
        if (minutes > 30) {
            long extra = ((minutes + 9) / 10) - 3;
            fee += (int) (extra * 500);
        }

        // 2만원 초과시 2만원으로 고정
        if (fee > 20000){
            fee = 20000;
        }

        // 경차할인
        if (compact) {
            fee /= 2;
        }

        return fee;
    }
}