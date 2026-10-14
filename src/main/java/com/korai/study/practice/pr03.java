package com.korai.study.practice;

import java.util.ArrayList;
import java.util.List;

public class pr03 {
    public static void main(String[] args) {

        // 11
        Circle a = new Circle(2);
        Circle b = new Circle(3);
        System.out.printf("%.2f%n", a.area());
        System.out.printf("%.2f%n", Circle.larger(a, b).area());

        // 12
        Member m1 = new Member("일일일");
        Member m2 = new Member("이이이");
        Member m3 = new Member("삼삼삼");
        m2.introduce();
        System.out.println(Member.getTotalCount());

        // 13
        Person p = new Person("장서현", 2000);
        System.out.println(Person.isLeapYear(2024));
        System.out.println(p.getAge(2026));
        System.out.println(p.bornInLeapYear());

        // 14
        Product x = new Product("키보드", 50000);
        Product y = new Product("마우스", 30000);
        System.out.println(x.discountedPrice(20));
        System.out.println(Product.withVat(30000));
        System.out.println(Product.cheaper(x, y).name);

        // 15
        Player p1 = new Player("A");
        Player p2 = new Player("B");
        Player p3 = new Player("C");
        p1.addScore(30);
        p2.addScore(50);
        p3.addScore(20);
        p1.addScore(25);

        // 플레이어 정보 배열에 담기
        Player[] players = new Player[]{p1, p2, p3};

        Player.getWinner(players).print();
    }
}

// 11
class Circle {
    private double radius;
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }

    public static Circle larger(Circle r1, Circle r2) {
        if (r1.area() > r2.area()) {
            return r1;
        }
        return r2;
    }
}

// 12
class Member {
    private String name;
    private int id;
    private static int count = 0;

    public Member(String name) {
        count++;
        this.name = name;
        this.id = count;
    }

    public void introduce() {
        System.out.printf("%d번 회원 %s입니다.\n", id, name);
    }

    public static int getTotalCount() {
        return count;
    }
}

// 13
class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    // (연도가 4로 나누어떨어짐)이고, (100으로 나누어떨어지지 않음) 또는 (400으로 나누어떨어짐)
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 || year % 100 == 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public int getAge(int year) {
        return year - birthYear;
    }

    public boolean bornInLeapYear() {
        if (birthYear % 4 == 0 ||  birthYear % 100 == 0 || birthYear % 400 == 0) {
            return true;
        }
        return false;
    }

}

// 14
class Product {
    String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int discountedPrice(int percent) {
        int discounted = price * percent / 100;
        return price - discounted;
    }

    public static int withVat (int price) {
        int vat = price * 10 / 100;
        return price + vat;
    }

    public static Product cheaper(Product p1, Product p2) {
        if (p1.price < p2.price) {
            return p1;
        }
        return p2;
    }
}

// 15
class Player {
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public static Player getWinner(Player[] players) {
        Player winner = players[0];
        for (int i = 0; i < players.length; i++) {
            if (players[i].score > winner.score) {
                winner = players[i];
            }
        }
        return winner;
    }

    public void print() {
        System.out.println(this.name + " " + this.score);
    }
}