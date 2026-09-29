package com.korai.study.ch03.access;

public class AccessMain2 {

    static class School {
        String name;
    }

    public static void main(String[] args) {
        School s1 = new School();
        s1.name = "부경대";

        System.out.println(s1);
        System.out.println(s1.name);
    }

    public static void run() {
        School s1 = new School();
        s1.name = "부경대";
    }
}

class AccessMain3 {
    static void run() {
        AccessMain2.School s1 = new AccessMain2.School();
    }
}