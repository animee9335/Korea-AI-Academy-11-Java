package com.korai.study.ch12;

import java.util.ArrayList;

class 내가만든예외 extends RuntimeException {
    public 내가만든예외(String message) {
        super(message);
    }
}

public class CollectionMain04 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(100);
        nums.add(200);
        nums.add(300);
        nums.add(400);
        nums.add(500);

        try {
            print(nums, nums.size() + 2);
        } catch (IndexOutOfBoundsException e){
            System.out.println("인덱스 초과 오류 해결함.");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Null 주소 오류 해결함.");
            e.printStackTrace();
        } catch (내가만든예외 e) {
            System.out.println("예외처리");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");
    }

    /*    try { 예외를 처리할 부분

    } catch() { 오류가 나면 작동하는 부분

    }

    먼저 발생한 오류부터 catch한다.
    throws Exception을 메소드 뒤에 작성해서 메소드를 사용할 때 확인하게 끔 가능하다.
    throws Exception은 모든 예외처리를 한다.
    RuntimeExcption을 상속 받은 예외처리는 꼭 예외처리 할 필요 없다.
    */

    static void print(ArrayList<Integer> nums, int size) throws Exception {
        System.out.println("리스트크기: " + nums.size());

        if (size == 7) {
            throw new 내가만든예외("내가 강제로 호출한 예외");
        }

        for (int i = 0; i < size; i++) {
            System.out.println(nums.get(i));
        }
        System.out.println();
    }
}

