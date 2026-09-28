package com.korai.study.ch03.access;

class Teacher {
    private String name;

    // Setter
    void setName(String name) {
        this.name = name;
    }

    // Getter
    String getName() {
        return name;
    }
}

public class AccessMain {

    static class Student {
        String name;
        int age;
    }

    public static void main(String[] args) {
        Student s1 =  new Student(); // 코드를 읽을 땐 자료형을 먼저 확인 후 흐름을 읽는다.
        s1.name = "장서현";
        s1.age = 27;
        System.out.println(s1.age);

        run1();
    }

    static void run1() {
        Student s1 =  new Student();
        s1.name = "장서현";
        s1.age = 27;

        Teacher t1 = new Teacher();
//        t1.name = "빵";
        t1.setName("빵");
        System.out.println(t1.getName());
    }
}