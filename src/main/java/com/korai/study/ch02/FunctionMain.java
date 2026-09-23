package com.korai.study.ch02;

import java.lang.invoke.StringConcatException;

public class FunctionMain {

    public static void main(String[] args) {
        /*
            [ 함수 ]
            반복적인 작업을 다시 사용할 수 있도록 정의(도구를 만드는 것)
            java에선 클래스 내부에 함수를 작성해야한다.

            클래스 내부의 함수는 메소드(Method)라 부른다.

            1. 재사용성
            2. 정리
        */

        String date = "2026-09-23";
        String name = "장서현";
        String content = "숨쉬기";

//        System.out.println("업무일지[ " + date + "]");
//        System.out.println("이름: " + name );
//        System.out.println("내용: " + content );
//        System.out.println();

        class Work {
            String date;
            String name;
            String content;

            void print() {
                System.out.println("업무일지[ " + date + " ]");
                System.out.println("이름: " + name );
                System.out.println("내용: " + content );
                System.out.println();
            }

            // 매개 변수를 객체에 저장
            void print2(String d, String n, String c) {
                date = d;
                name = n;
                content = c;

                System.out.println("업무일지[ " + date + " ]");
                System.out.println("이름: " + name );
                System.out.println("내용: " + content );
                System.out.println();
            }

            // 매개 변수를 저장하지 않고 실행
            void print3(String d, String n, String c) {
                System.out.println("업무일지[ " + d + " ]");
                System.out.println("이름: " + n );
                System.out.println("내용: " + c );
                System.out.println();
            }

            // "2026-09-23" -> 2026년 09월 23일
            String translate(String d) {
                String[] splitDate = d.split("-");
                String year = splitDate[0];
                String month = splitDate[1];
                String day = splitDate[2];
                return year + "년" + month + "월" + day + "일";
            }

            int add (int x, int y) {
                return x + y;
            }

        }

        Work w1 = new Work();
        w1.date = "2026-09-24";
        w1.name = "장서현";
        w1.content = "잠자기";
        w1.print(); // 함수 호출

        Work w2 = new Work();
        w2.print2("2026-09-25", "장서현", "숨쉬기");
        System.out.println(w2.name + "\n"); // 객체에 값이 함수로 저장되어 출력해도 결과가 나온다.

        Work w3 = new Work();
        w3.print3("2026-09-26", "장서현", "밥먹기");
        System.out.println(w3.name + "\n"); // 값이 객체에 저장되지 않기 때문에 null로 값을 반환한다.

        Work w4 = new Work();
        System.out.println(w4.translate("2027-01-01"));
        System.out.println(w4.add(1,2));


    }

}
