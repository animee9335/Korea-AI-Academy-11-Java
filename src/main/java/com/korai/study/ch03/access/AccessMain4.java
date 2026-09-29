package com.korai.study.ch03.access;

public class AccessMain4 {
    public static void main(String[] args) {
        School2 s2 = new School2();
        // s2.name = "학교"; private으로 지정되어 있기 때문에 참조 불가능하다.
        s2.setName("학교");
        System.out.println(s2.getName());
    }
}

class AccessMain5 {
    static void run() {
        School2 s2 = new School2();

    }
}

class School2 {
    private String name;

    // setter
    void setName(String name) {
        this.name = name;
    }

    // getter
    String getName() {
        return name;
    }
}