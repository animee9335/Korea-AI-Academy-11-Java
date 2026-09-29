package com.korai.study.ch04;

import java.util.Arrays;

public class ArrayMain04 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) nums[i] = i + 1; // 한 줄이면 {} 생략가능

        System.out.println(arrayToString(nums));
        System.out.println(arrayToString1(nums));
        System.out.println(Arrays.toString(nums));
    }

    static String arrayToString(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                str += "[ " + arr[i];
            } else if (i == arr.length - 1) {
                str += ", " + arr[i] + " ]";
            } else
            str += ", " + arr[i];
        }
        return str;
    }

    static String arrayToString1(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) str += "[ ";
            str += arr[i] + ", ";
            if (i == arr.length - 1) str += " ]";

        }
        return str;
    }
}
