package com.korai.study.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Todo {
    private int id;
    private TodoStatus status = TodoStatus.todo;
    private String content;
    private User user; // Todo를 누가 작성했는지에 대한 정보
}
