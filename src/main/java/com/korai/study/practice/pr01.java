package com.korai.study.practice;

public class pr01 {
    public static void main(String[] args) {

        // 1
        System.out.println(MathUtil.max(3, 9, 5));

        // 2
        System.out.println(TempConverter.toFahrenheit(36.5));
        System.out.println(TempConverter.toCelsius(212));

        // 3
        System.out.println(StringUtil.isPalindrome("level"));
        System.out.println(StringUtil.isPalindrome("java"));

        // 4
        System.out.printf("%.1f%n", ArrayUtil.average(new int[] {80, 95, 70}));

        // 5
        System.out.println(Validator.isValidPassword("abc12345"));
        System.out.println(Validator.isValidPassword("abcdefgh"));
        System.out.println(Validator.isValidPassword("a1b2"));
    }
}

// 1
class MathUtil {

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        }
        return c;
    }
}

// 2
class TempConverter {

    public static double toFahrenheit(double n) {
        return n * 9 / 5 + 32;

    }

    public static double toCelsius(double n) {
        return (n - 32) * 5 / 9;
    }
}

// 3
class StringUtil {

    public static boolean isPalindrome(String s) {
        int length = s.length();

        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

// 4
class ArrayUtil {

    public static double average(int[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}

// 5
class Validator {
    public static boolean isValidPassword(String pw) {
        if (pw.length() >= 8) {
            if (pw.matches(".*[0-9].*")) {
                return true;
            }
            return false;
        }
        return false;
    }
}