package com.korai.study.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class ControlMain6 {

    static String[] arrayAdd(String[] names, String name) {
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = name;

        return names;
    }

    public static void main(String[] args) {
        // while 반복문
        String[] names = new String[0];
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름 입력 프로그램");
        System.out.println("입력을 멈추시리면 그냥 Enter를 입력하세요.");

        while (true) {
            System.out.println("이름을 추가하시겠습니까?(y/n)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.print("이름: ");
                String name = scanner.nextLine();

                //names = arrayAdd(names, name);
                String[] newNames = new String[names.length + 1];
                for (int i = 0; i < names.length; i++) {
                    newNames[i] = names[i];
                }
                newNames[names.length - 1] = name;
                names = newNames;

            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("종료합니다.");
                break;
            }
            else {
                System.out.println("다시 입력하세요.");
            }
        }
        System.out.println(Arrays.toString(names));
    }
}
