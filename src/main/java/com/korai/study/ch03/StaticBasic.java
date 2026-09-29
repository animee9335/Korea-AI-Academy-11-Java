package com.korai.study.ch03;

import java.time.LocalDate;

public class StaticBasic {
    public static void main(String[] args) {
        // MethodArea.main(null); // public static void main(String[] args) 또한 static이 붙어 객체없이 호출 가능하다.

        StudentManage system = new StudentManage();
        // Student addStudent(String name){} 일 때
        Student s1 = system.addStudent("빵1");
        Student s2 = system.addStudent("빵2");
        Student s3 = system.addStudent("빵3");

        // static Student addStudent(String name){} 일 때
        Student s4 = StudentManage.addStudent("빵4");
        Student s5 = StudentManage.addStudent("빵5");
        Student s6 = StudentManage.addStudent("빵6");

        System.out.println(s1.name + " " + s1.studentNum);
        System.out.println(s2.name + " " + s2.studentNum);
        System.out.println(s3.name + " " + s3.studentNum);
        System.out.println(s4.name + " " + s4.studentNum);
        System.out.println(s5.name + " " + s5.studentNum);
        System.out.println(s6.name + " " + s6.studentNum);
    }
}

class Student{
    int studentNum; // 변수(필드) = 인스턴스 변수
    String name;    // 변수(필드) = 인스턴스 변수, 인스턴스 = 실존하는 객체

    Student(int studentNum, String name) {
        System.out.println("생성자 호출");
        this.studentNum = studentNum; // 자기자신을 this로 가리킨다.
        this.name = name;
    }
}

class StudentManage  {
    static int year = LocalDate.now().getYear(); // .now처럼 이텔릭체로 작성된 코드는 static으로 작성된 것이다.
    static int num = 0;

    static {
        System.out.println("학생관리시스템 클래스 로딩");
    }

    static Student addStudent(String name) {
        return new Student(year + 10000 + num++, name);
    }
}