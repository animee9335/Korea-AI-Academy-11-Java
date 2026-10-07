package com.korai.study.ch09.practice;

import java.util.ArrayList;

public class BookMain {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository(new ArrayList<>());

        Book b1 = new Book(null, "죄와 벌", "도레미", 10000,"1234");
        Book b2 = new Book(null, "햄릿", "레미", 20000, "1235");
        Book b3 = new Book(null, "리어왕", "미", 30000, "1236");

        bookRepository.insert(b1);
        bookRepository.insert(b2);
        bookRepository.insert(b3);

        bookRepository.printAll();
        System.out.println("=======================");
        bookRepository.findById(2l);
        System.out.println(bookRepository.updatePrice(1l, 25000));
        System.out.println(bookRepository.delete(3l));
        System.out.println(bookRepository.delete(99l));
        System.out.println("=======================");
        System.out.println(bookRepository.findByAuthor("도미"));
    }
}
