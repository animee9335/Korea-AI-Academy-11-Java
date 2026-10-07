package com.korai.study.ch10.TODO.router;

import com.korai.study.ch10.TODO.repository.TodoRepository;
import com.korai.study.ch10.TODO.repository.UserRepository;
import com.korai.study.ch10.TODO.service.TodoService;
import com.korai.study.ch10.TODO.service.UserService;
import com.korai.study.ch10.TODO.view.*;

import java.util.Map;

public class RootRouter {
    private static String current = "login";
    private static Map<String, View> viewMap;


    public static void setUp() {
        UserRepository userRepository = new UserRepository(); // 유저 정보 리스트 생성 및 탐색 기능
        UserService userService = new UserService(userRepository); // 유저 정보가 존재하는지 검사
        LoginView loginView = new LoginView(userService); // 로그인 기능 화면 출력

        TodoRepository todoRepository = new TodoRepository(); // todolist 내용을 담을 리스트 생성 및 삽입, 탐색기능
        TodoService todoService = new TodoService(todoRepository, userRepository); // todolist 등록 및 업데이트
        TodoListView todoListView = new TodoListView(todoService); // todolist를 조작할 수 있는 화면 출력

        TodoRegister todoRegister = new TodoRegister(todoService); // todolist 내용 등록
        TodoStatusView todoStatusView = new TodoStatusView(todoService); // todolist 상태 변환

        // Map을 통해 원하는 화면으로 이동
        viewMap = Map.of(
                "login", loginView,
                "todo-list", todoListView,
                "todo-register", todoRegister,
                "todo-status", todoStatusView
        );
    }

    // 맵의 값을 가져오거나 세팅함
    public static String getCurrent() {
        return current;
    }

    public static void setCurrent(String path) {
        current = path;
    }

    // 현재 맵의 값을 반환하고 그 위치의 인터페이스 메소드를 사용, 긴 코드 작성없이 간단하게 사용가능하게 함.
    public static View getCurrentView() {
        return viewMap.get(current);
    }

}
