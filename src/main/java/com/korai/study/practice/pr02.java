package com.korai.study.practice;

import java.util.ArrayList;
import java.util.List;

public class pr02 {
    public static void main(String[] args) {

        // 6
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.increment(); c1.increment(); c1.increment();
        c2.increment();

        System.out.println(c1.getCount() + " " + c2.getCount());

        // 7
        Rectangle r = new Rectangle(4, 5);
        System.out.println(r.area() + " " + r.perimeter() + " " + r.isSquare());

        // 8
        BankAccount acc = new BankAccount("장서현", 10000);
        acc.deposit(5000);
        System.out.println(acc.withdraw(20000));
        System.out.println(acc.withdraw(3000));
        System.out.println(acc.getBalance());

        // 9
        Student s = new Student("장서현", 90, 35, 80);
        System.out.printf("%d %.1f, %b%n", s.total(), s.average(), s.isPass());

        // 10
        Cart cart = new Cart();
        cart.add("펜", 1500, 3);
        cart.add("노트", 3000, 2);
        System.out.println(cart.getTotal());
        System.out.println(cart.getTotal(10));

    }
}

// 6
class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}

// 7
class Rectangle {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return width * 2 + height * 2;
    }

    public boolean isSquare() {
        return width == height;
    }
}

// 8
class BankAccount {
    private String owner;
    private int balance;

    BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }
}

// 9
class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private double average;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int total() {
        return kor + eng + math;
    }

    public double average() {
        average = (kor + eng + math) / 3.0;
        return average;
    }

    public boolean isPass() {
        if (average >= 60 && kor >= 40 && eng >= 40 && math >= 40) {
            return true;
        }
        return false;
    }
}

// 10
class Cart {

    private static class Item {
        private String name;
        private int price;
        private int qty;

        public Item(String name, int price, int qty) {
            this.name = name;
            this.price = price;
            this.qty = qty;
        }
    }

    private List<Item> items = new ArrayList<>();

    public void add(String name, int price, int qty) {
        items.add(new Item(name, price, qty));
    }

    public int getTotal() {
        int total = 0;
        for (Item item : items) {
           total += item.price * item.qty;
        }
        return total;
    }

    public int getTotal(int couponPercent) {
        int total = 0;
        for (Item item : items) {
            total += item.price * item.qty;
        }
        int sale = total * couponPercent / 100;
        total -= sale;
        return total;
    }


}