package com.korai.study.ch13;

// 람다
// 추상 페이스를 하나만 가지고 있는 인터페이스를 익명 객체로 생성할 때
// 편리하게 생성할 수 있도록 만들어진 문법
public class Lambda01 {
    public static void main(String[] args) {
        KeyBoardEvent keyboard = new KeyBoardEvent() {
            @Override
            public void keyUp() {
                System.out.println("키 업");
            }
            @Override
            public void keyDown() {
                System.out.println("키 다운");
            }
        };

        keyboard.keyUp();
        keyboard.keyDown();

//        Speaker speaker1 = new Speaker() {
//            @Override
//            public void play() {
//                System.out.println("A 사운드를 재생");
//            }
//        };


        Speaker speaker2 = () -> System.out.println("B 사운드를 재생");

//        speaker1.play();
        speaker2.play();
    }
}

interface KeyBoardEvent {
    void keyUp();
    void keyDown();
}

interface Speaker {
    void play();
}