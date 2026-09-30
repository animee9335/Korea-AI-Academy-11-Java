package com.korai.study.ch05;

public class ControlMain {
    public static void main(String[] args) {
        // 1. 조건문
        if (true) System.out.println("Hello World1");
        if (false) System.out.println("Hello World2");

        boolean open = true;
        if (!open) System.out.println("열림");
        else System.out.println("닫힘");

        int score = 70;
        if (score < 60) System.out.println("F");
        else if (score < 70) System.out.println("D");
        else if (score < 80) System.out.println("C");
        else if (score < 90) System.out.println("B");
        else System.out.println("A");

        System.out.println(score < 60 ? "F" : score < 70 ? "D" : score < 80 ? "C" : score < 90 ? "B" : "A");
        // 같아 보이지만 if는 조건에 따라 명령을 실행시키는 것이고, 삼항연산자는 연산자이기 때문에 값을 연산하는 것이다.


    }
}
