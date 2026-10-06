package com.korai.study.ch08;

import java.util.Objects;

public class Object02 {
    public static void main(String[] args) {
        class Student {
            private String name;
            private int age;
            private String address;

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                // return age == student.age && name.equals(student.name); 작동은 하나 name이 null인 경우 에러가 발생할 수 있다.
                return age == student.age && Objects.equals(name, student.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age, address);
            }

            public Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public Student(String name, int age, String address) {
                this.name = name;
                this.age = age;
                this.address = address;
            }
        }

        Student student1 = new Student("장서현", 10);
        Student student2 = new Student("장서현", 10);
        Student student3 = student1;
        Student student4 = new Student("장서현", 10, "부산");


        boolean result1 = student1.equals(student2);
        boolean result2 = student1.equals(student3);

        System.out.println(student1);
        System.out.println(student1.toString());
        System.out.println(Integer.toHexString(student1.hashCode()));
        System.out.println(student1.hashCode());
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(result1);
        System.out.println(result2);

        System.out.println(student1 == student2);
        System.out.println(student1 == student3);
        System.out.println(student1 == student4);

//        System.out.println(student1.hashCode() == student2.hashCode());
//        System.out.println(student1.hashCode());
//        System.out.println(student2.hashCode());
          System.out.println(student4);
          System.out.println(student4.hashCode());
          System.out.println(Integer.toHexString(student4.hashCode()));
    }
}
