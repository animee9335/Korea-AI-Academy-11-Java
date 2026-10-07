package com.korai.study.ch10.TODO.view;

import com.korai.study.ch10.TODO.router.RootRouter;
import com.korai.study.ch10.TODO.service.TodoService;

import java.util.Scanner;

public class TodoRegister implements View{
    private final TodoService todoService;
    private Scanner scanner;

    public TodoRegister(TodoService todoservice) {
        this.todoService = todoservice;
        scanner = new Scanner(System.in);
    }

    // register 기본 화면 출력
    @Override
    public void show() {
        String content;
        System.out.println("[ 할 일 등록하기 ]");
        System.out.print("내용: ");
        content = scanner.nextLine();
        todoService.register(content); // 내용이 입력되면 리스트에 내용 추가
        RootRouter.setCurrent("todo-list"); // 입력이 끝나면 todolist view로 이동
    }
}

