package com.korai.study.ch10.TODO;

import com.korai.study.ch10.TODO.router.RootRouter;

public class TodoApplication {
    public static void main(String[] args) {
        // 라우터를 통해 한번에 객체 생성
        RootRouter.setUp();

        // 종료하기 전까지 반복
        while(true) {
            RootRouter.getCurrentView().show(); // 인터페이스를 상속받아 view가 바뀔 때마다 그 view의 show()를 실행
        }
    }
}
