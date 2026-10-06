package com.korai.study.ch10;

public class SingletonMain {
    public static void main(String[] args) {
        StudentService studentService = StudentService.getInstance();
        StudentService studentService2 = StudentService.getInstance();

        System.out.println(studentService ==  studentService2);

        studentService.run();
        studentService2.run();
    }
}

class StudentService {
    private static StudentService instance;

    private StudentService() {}

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public static void run() {
        System.out.println("1");
    }

}