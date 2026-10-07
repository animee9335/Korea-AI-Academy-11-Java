package com.korai.study.ch10.TODO.service;

import com.korai.study.ch10.TODO.config.SecurityConfig;
import com.korai.study.ch10.TODO.entity.Todo;
import com.korai.study.ch10.TODO.entity.TodoStatus;
import com.korai.study.ch10.TODO.entity.User;
import com.korai.study.ch10.TODO.repository.TodoRepository;
import com.korai.study.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public List<Todo> getTodoList() {
        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    // 추가한 내용과 유저 정보를 담아 값을 넘겨줌
    public void register(String content){
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    // todoID, todoStatus의 값을 todoRepository.updateStatus()에 넘겨줌
    public void updateStatus(int todoID, TodoStatus todoStatus) {
        todoRepository.updateStatus(todoID, todoStatus);
    }
}
