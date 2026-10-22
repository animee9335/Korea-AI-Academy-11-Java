package com.korai.study.ch13;

public class Lambda02 {
    public static void main(String[] args) {
        Calculator01 calculator01 = () -> {
            System.out.println("명령1");
            System.out.println("명령2");
        };

        Calculator01 calculator01_1 = () -> System.out.println("명령1");

        Calculator02 calculator02 = () -> {
            System.out.println("명령1");
            System.out.println("명령2");
            return 0;
        };

        Calculator02 calculator02_1 = () -> 10;

        Calculator03 calculator03 = (int num) -> {
            return 0;
        };

        // 자료형 생략 가능
        Calculator03 calculator03_1 = (num) -> {
            return 0;
        };

        // 매개변수 하나면 괄호 생략 가능
        Calculator03 calculator03_2 = num -> num + 1;

        Calculator04 calculator04 = (int num1, int num2) -> {
            return num1 + num2;
        };

        // 자료형 생략 가능
        Calculator04 calculator04_1 = (num1, num2) -> {
            return num1 + num2;
        };

        // 매개변수명을 바꿔도 상관없다.
        Calculator04 calculator04_2 = (a, b) -> a + b;
    }
}

@FunctionalInterface // 람다전용으로 쓰기 위해 작성한다. 내부에 추가로 추상메소드를 작성 못함.
interface Calculator01 {
    void calc();
}

@FunctionalInterface
interface Calculator02 {
    int calc();
}

@FunctionalInterface
interface Calculator03 {
    int calc(int num);
}

@FunctionalInterface
interface Calculator04 {
    int calc(int num1, int num2);
}