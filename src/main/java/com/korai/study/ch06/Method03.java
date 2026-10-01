package com.korai.study.ch06;

public class Method03 {
    public static void main(String[] args) {
        System.out.println(new Student());
        System.out.println(new Student("도라에몽"));
        System.out.println(new Student("진구", 10));
        System.out.println(new Student(10, "부산"));
    }
}

class Student {
    String name;
    int age;
    String address;

    Student() {
        System.out.println("나는 학생");
    }

    Student(String name) {
        System.out.println("학생이름: " + name);
        this.name = name;
    }

    Student(String name, int age) {
        System.out.printf("학생이름: %s, 나이: %d\n", name, age);
        this.name = name;
        this.age = age;
    }

    // 매개변수의 자료형이 같아도 안된다.
//    Student(String address) {
//        System.out.println("주소");
//    }

    // 자료형이 같더라도 매개변수의 순서가 다르다면 가능하다.
    Student(int age, String address) {
        System.out.printf("나이: %d, 주소: %s\n", age, address);
        this.address = address;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}