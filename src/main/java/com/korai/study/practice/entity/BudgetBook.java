package com.korai.study.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BudgetBook {
    private int id;
    private String category;
    private int String;
    private String memo;
    private LocalDate date;
    private User user;
}
