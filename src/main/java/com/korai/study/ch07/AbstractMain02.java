package com.korai.study.ch07;

public class AbstractMain02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        Animal animal = new Animal();
        Animal animal1 = dog;
        Animal animal2 = tiger;
    }
}

class Animal {
    String name;

    void move() {
        System.out.println("움직인다");
    }
}

class Dog extends Animal {
    String name;

    void move() {
        System.out.println("움직인다");
    }

    void bark() {
        System.out.println("짖다");
    }
}

class Tiger extends Animal {
    // 따로 명시를 하지 않는 한 Animal의 name을 가지고 있다.
    void hunt() {
        System.out.println("사냥하다");
    }
}