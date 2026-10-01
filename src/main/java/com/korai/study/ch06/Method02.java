package com.korai.study.ch06;

public class Method02 {
    public static void main(String[] args) {
        Parameter01.call();
        Parameter01.call(1);
        Parameter01.call(3, 2.0);
    }
}

// Parameter ==> 매개변수, 매개변수를 기준으로 오버로딩 되는 것. 메서드 자료형이 다른 건 안된다.
// Parameter Overloading
class Parameter01 {

    static void call() {
        System.out.println("1");
    }

    static void call(int num) {
        System.out.println("2");
    }

    static void call(int num, double num2) {
        System.out.println("3");
    }



}

