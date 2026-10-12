  package com.korai.study.ch11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  싱글톤(Singleton)은 클래스의 인스턴스를 프로그램 전체에서 딱 하나만 만들고, 어디서든 그 하나를 공유해서 쓰게 하는 설계 방식
*/

public class TodoMain {
        public static int pathIndex = 0;
        public static boolean running = true;

    public static void main(String[] args) {

        // 객체를 담는 리스트
        List<View> viewList = new ArrayList<>();
        viewList.add(HomeView.getInstance());
        viewList.add(RegisterView.getInstance());
        viewList.add(ListView.getInstance());
        viewList.add(DeleteView.getInstance());

        Scanner scanner = new Scanner(System.in);

        while (running) {
            viewList.get(pathIndex).show();
        }
    }
}

// Object(최상위) 클래스
// 정보를 관리할 수 있도록 도와줄 Entity클래스
@AllArgsConstructor
@NoArgsConstructor // 비어 있는 기본 생성자
@Data
class Todo {
    private int id;
    private String content;

    @Override
    public String toString() {
        return String.format("[%d번] | %s", id, content);
    }
}

// 기능을 추상화 할 때 사용
// 인터페이스로 기능을 추상화 했으면 구현 객체는 무조건 존재할 것이다.
interface View {
    void show();
}

// 클래스는 생성(메모리에 인스턴스를 실존하게 하는 것) 가능해야한다.
class HomeView implements View {

    // 싱글톤 2번, 해당 클래스 자료형의 인스턴스를 담아둘 static 변수를 선언한다.
    private static HomeView instance;

    // 싱글톤 1번, 생성자를 private으로 정의한다.
    // 생성자를 숨겼다는 것은 외부에서 생성을 제한하기 위함이다.
    private HomeView() {

    }

    // 싱글톤 3번, static 변수 homeView가 null일 때 인스턴스를 생성
    // static getter를 통해서만 instance에 접근할 수 있게 유도.
    public static HomeView getInstance() {
        while (instance == null) {
            instance = new HomeView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String cmd;

        System.out.println("[ HOME ]");
        System.out.println("1. TODO 등록하기");
        System.out.println("2. TODO 목록조회");
        System.out.println("3. TODO 삭제하기");
        System.out.println("0. 프로그램 종료");
        System.out.print(">>> ");

        cmd = scanner.nextLine().trim(); // trim은 양 옆 공백제거
        cmd = String.valueOf(cmd.charAt(0));
        cmd = cmd.toUpperCase();

//        boolean isAlphabet = cmd.matches("[a-zA-Z]");
        boolean isNumber = cmd.matches("[0-9]");
        if (!isNumber) {
//            System.out.println("영문자만 입력 가능합니다.");
            System.out.println("숫자만 입력 가능합니다.");
            return;
        }

        if ("Q".equals(cmd)) {
            TodoMain.running = false;
            return;
        } else if ("1".equals(cmd)) {
            TodoMain.pathIndex = 1;
        } else if ("2".equals(cmd)) {
            TodoMain.pathIndex = 2;
        } else if ("3".equals(cmd)) {
            TodoMain.pathIndex = 3;
        } else {
            System.out.println("다시 입력해주세요.");
        }
    }
}

class RegisterView implements View {
    private static RegisterView instance;

    private RegisterView() {

    }

    public static RegisterView getInstance() {
        while (instance == null) {
            instance = new RegisterView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String content;

        System.out.println("[ REGISTER ]");
        System.out.println("내용을 입력하세요. ");
        System.out.print(">>> ");
        content = scanner.nextLine().trim();
        Todo newTodo = new Todo();
        newTodo.setContent(content);
        TodoRepository.getInstance().insert(newTodo);
        System.out.println("TODO 등록 완료");
        TodoMain.pathIndex = 0;
    }
}

class ListView implements View {

    private static ListView instance;

    private ListView() {

    }

    public static ListView getInstance() {
        while (instance == null) {
            instance = new ListView();
        }
        return instance;
    }

    @Override
    public void show() {
        System.out.println("[ LIST ]");
        List<Todo> todos = TodoRepository.getInstance().findAll();

        if (todos.isEmpty()) {
            System.out.println("등록된 TODO가 없습니다.");
            TodoMain.pathIndex = 0;
            return;
        }
        for (Todo todo : todos) {
            System.out.println(todo.toString());
        }
        TodoMain.pathIndex = 0;
    }
}

class DeleteView implements View {
    private static DeleteView instance;

    private DeleteView() {

    }

    public static DeleteView getInstance() {
        if (instance == null) {
            instance = new DeleteView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        int cmd;

        System.out.println("[ DELETE ]");

        List<Todo> todos = TodoRepository.getInstance().findAll();

        if (todos.isEmpty()) {
            System.out.println("등록된 TODO가 없습니다.");
            TodoMain.pathIndex = 0;
            return;
        }
        for (Todo todo : todos) {
            System.out.println(todo.toString());
        }

        System.out.println("삭제할 LIST의 ID를 입력해주세요.");
        System.out.print(">>> ");
        cmd = scanner.nextInt();
        TodoRepository.getInstance().delete(cmd);

        TodoMain.pathIndex = 0;
    }
}

//class UpdateView implements View {
//    private static UpdateView instance;
//
//    private UpdateView() {
//
//    }
//
//    public static UpdateView getInstance() {
//        if (instance == null) {
//            instance = new UpdateView();
//        }
//        return instance;
//    }
//
//    @Override
//    public void show() {
//        Scanner scanner = new Scanner(System.in);
//        String cmd;
//
//        System.out.println("[ UPDATE ]");
//
//        List<Todo> todos = TodoRepository.getInstance().findAll();
//
//        if (todos.isEmpty()) {
//            System.out.println("등록된 TODO가 없습니다.");
//            TodoMain.pathIndex = 0;
//            return;
//        }
//        for (Todo todo : todos) {
//            System.out.println(todo.toString());
//        }
//
//        System.out.println("내용을 변경할 ID를 입력해주세요");
//        System.out.print(">>> ");
//        cmd = scanner.nextLine().trim();
//
//    }
//}

interface Repository<T> {
    void insert(T t);
    void update(T t);
    T delete(int id);
    T findById(int id);
    List<T> findAll();
}

class TodoRepository implements Repository<Todo>{
    private static TodoRepository instance;
    private int lastId;
    private List<Todo> todos;

    private TodoRepository() {
        lastId = 1;
        todos = new ArrayList<>();
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }
        return instance;
    }

    private void renumber() {
        for (int i = 0; i < todos.size(); i++) {
            todos.get(i).setId(i + 1);
        }
    }


    @Override
    public void insert(Todo todo) {
        todo.setId(todos.size() + 1);
        todos.add(todo);
    }

    @Override
    public void update(Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == todo.getId()) {
                todos.set(i, todo);
                break;
            }
        }
    }

    @Override
    public Todo delete(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                Todo removed = todos.remove(i);
                renumber();
                return removed;
            }
        }
        return null;
    }

    @Override
    public Todo findById(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                return todos.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Todo> findAll() {
        // 추가적인 변경이 가능하다.
//        List<Todo> copyTodos = new ArrayList<>();
//        copyTodos.addAll(todos);
//        return copyTodos;

        return List.copyOf(todos); // 불변 리스트라 변경이 불가능
    }
}