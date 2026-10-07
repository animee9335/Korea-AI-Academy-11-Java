package com.korai.study.ch10.TODO.entity;

// 열거형
public enum TodoStatus {
    todo("진행 전"), inProgress("진행 중"), done("완료"); // 문자열이라고 봐도 된다.

    private String status;

    TodoStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
