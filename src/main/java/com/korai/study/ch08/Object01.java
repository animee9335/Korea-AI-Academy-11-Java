package com.korai.study.ch08;

public class Object01 {
    // 최상위 클래스 (Object)
    public static void main(String[] args) {

        // 인스턴스와 무관하게 클래스에 대한 정보를 가져오는 것이다.
        System.out.println(Student.class.getName());
        System.out.println(new Student().getClass().getName());
        System.out.println(new Student() instanceof Student);
        System.out.println(new Student().getClass() == Student.class);
        System.out.println(new Student().hashCode());
        Student s = new Student();
        System.out.println(s.hashCode());
        System.out.println(Integer.toHexString(s.hashCode()));
        System.out.println(s.toString());
        System.out.println(s);

        String str = s.toString();
//        String str1 = s;
        Student str2 = s;

        HighStudent h1 = new HighStudent();
        System.out.println(h1);

        Teacher t1 = new Teacher("장서현", 20, "부산");
        System.out.println(t1);
    }
}

// 기본적으로 클래스는 Object 클래스를 상속받고 있으나 생략되어 있는 것이다.
class Student extends Object {

}

class HighStudent extends Student {
//    @Override
//    public String toString() {
//        return "새로 정의 가능";
//    }

    // toString()은 객체가 가지고 있는 데이터를 문자열로 시각화 할 때 사용.
    @Override
    public String toString() {
        return super.toString();
    }
}

class Teacher {
    private String name;
    private int age;
    private String address;

    public Teacher(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
