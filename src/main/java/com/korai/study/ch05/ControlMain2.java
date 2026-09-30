package com.korai.study.ch05;

public class ControlMain2  {
    public static void main(String[] args) {
        // switch ~ cas => IF 조건문과는 완전히 다른 동작 방식이다.
        //

//        String doorSelect = "";
//
//        switch (doorSelect) {
//            case "A":
//                System.out.println("A문");
//                break;
//            case "B":
//                System.out.println("B문");
//                break;
//            case "C":
//                System.out.println("C문");
//                break;
//            case "D":
//                System.out.println("D문");
//                break;
//            default:
//                System.out.println("E문");
//                break;
//        }
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("몇 월인지 입력해주세요: ");
//        String month = sc.nextLine();
//
//        switch (month) {
//            case "1월", "3월", "5월", "7월", "8월", "10월", "12월":
//                System.out.println(month + " 31일");
//                break;
//            case "4월", "6월", "9월", "11월":
//                System.out.println(month + " 30일");
//                break;
//            default:
//                System.out.println(month + " 28일");
//                break;
//        }
//
//        Scanner sc2 = new Scanner(System.in);
//        System.out.print("몇 월인지 입력해주세요: ");
//        int month2 = sc2.nextInt();
//
//        switch (month2) {
//            case 1, 3, 5, 7, 8, 10, 12:
//                System.out.println("31일");
//                break;
//            case 4, 6, 9, 11:
//                System.out.println("30일");
//                break;
//            default:
//                System.out.println("28일");
//                break;
//        }

        String cmd = "STOP".toLowerCase();
        switch (cmd) {
            case "start": System.out.println("시작"); break;
            case "stop":  System.out.println("정지"); break;
            default:
        }
        System.out.println("알 수 없는 명령");

        // java 14버전 이상부터 사용 가능
        int score = 42;
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            default -> "F";
        };
        System.out.println(grade);

        // long 타입이 들어가는 switch문은 23버전 이상부터 사용 가능
        long code = 1L;
        switch ((int)code) {
            case 1: System.out.println(" 로그인");
        }

    }

    static void maxValue(int a, int b, int c) {
        if (a > b && a > c) System.out.println(a);
        else if (b > a && b > c) System.out.println(b);
        else System.out.println(c);
    }
}
