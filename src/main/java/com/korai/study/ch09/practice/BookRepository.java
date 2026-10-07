package com.korai.study.ch09.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepository {
    private Long autoIncrement = 1l;
    private final List<Book> bookList;

    BookRepository(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void insert(Book book) {
        book.setId(autoIncrement++);
        bookList.add(book);
        }

    public void printAll() {
        System.out.println("도서 전체 조회");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public Book findById(Long id) {
        System.out.println("선택한 도서 조회");
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public boolean updatePrice(Long id, int newPrice) {
        System.out.println("가격이 변경된 도서");
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                bookList.get(i).setPrice(newPrice);
                System.out.println(bookList.get(i));
                return true;
            }
        }
        return false;
    }

    public Book delete (Long id) {
        System.out.println("삭제된 도서");
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

}
