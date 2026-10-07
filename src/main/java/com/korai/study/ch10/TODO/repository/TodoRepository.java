package com.korai.study.ch10.TODO.repository;

import com.korai.study.ch10.TODO.entity.Todo;
import com.korai.study.ch10.TODO.entity.TodoStatus;
import com.korai.study.ch10.TODO.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private int autoIncrement = 1;
    @Getter
    private List<User> users = new ArrayList<>();
    @Getter // 이 변수에 한해서만 getter가 생긴다. 당연히 클래스 위에 작성하면 클래스 전체에 생긴다.
    private List<Todo> todos;

    public TodoRepository() {
        todos = new ArrayList<>();
    }

    // register에서 받은 값을 리스트에 추가
    public void insert(Todo todo) {
        todo.setId(autoIncrement++); // 추가될 때마다 Id 1씩 증가
        todos.add(todo); // 리스트에 추가
    }

    // 유저의 id와 일치하는 id의 todolist 값을 반환
    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteringTodos  = new ArrayList<>();
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getUser().getId() == userId) {
                filteringTodos.add(todos.get(i)); // Id가 일치하는 것만 리스트에 추가
            }
        }
        if (filteringTodos.size() == 0) return null;
        return filteringTodos;
    }

    // 선택한 Id의 status를 변경
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == todoId) {
                todos.get(i).setStatus(todoStatus);
                break;
            }
        }
    }

}
