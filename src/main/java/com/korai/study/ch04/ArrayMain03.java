package com.korai.study.ch04;

public class ArrayMain03 {
    public static void main(String[] args) {
        // 배열을 활용한 반복작업

        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int n = 0;
        while (n < 100) {
            nums[n] = n + 1;
            n++;
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
