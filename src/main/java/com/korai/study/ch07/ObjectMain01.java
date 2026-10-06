package com.korai.study.ch07;

public class ObjectMain01 {
    public static void main(String[] args) {
        final int num = 10;
        //num = 20; 상수는 대입할 수 없다.
        System.out.println(num);
        // 생성자를 통해 값을 대입할 수 있다.
        Student s1 = new Student(20260001, "또라에몽");
        Student s2 = new Student();

        School school = new School();
    }
}

class School {
    String name;

    // 생성자는 기본적으로 생략되어 있으나, 오버로딩을 하면 생략되어 있는 걸 삭제한다.
    School() {

    }

    School(String name) {
        this.name = name;
    }
}

class Student {
    final int code;     //필수, 초기화가 되지 않으면 클래스 내부에서는 사용할 수 없다. 단 한번이라도 초기화되면 사용할 수 있다.
    final String name;  //필수
    String address;     //선택

    // 매개변수가 없는 생성자가 있으면 사용할 수 없으나, default값을 대입하여 사용가능하게 할 수 있다.
    // NoArgumentsConstructor (인자들이 없는 생성자. 즉, 생성자의 매개변수가 없음)
    Student() {
        code = 0;
        name = null;
    }

    // RequiredArgumentsConstructor (필수인자들만 받는 생성자.)
    Student(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // AllArgumentsConstructor (모든 인자들을 다 받는 생성자.)
    Student(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }
}

class Teacher {
    String name;
    int age;
    String address;

    public Teacher(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
