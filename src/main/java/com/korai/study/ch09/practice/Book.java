package com.korai.study.ch09.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private int price;
    private String isbn;
}
