package com.korai.study.ch05;

public class ControlMain3 {
    public static void main(String[] args) {
//        System.out.println("""
//                장
//                서
//                현""");

/*        // 1
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2
        for(int i = 0; i < 5; i++) {
            String star = "";
            for(int j = 0; j < i + 1; j++) {
                star += "*";
            }
            System.out.println(star);
        }

        // 3
        String star = "";
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < i + 1; j++) {
                star +=  "*";
            }
            star += "\n";
        }
        System.out.println(star);
        */

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(5 - i);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 1 + i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
        System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
