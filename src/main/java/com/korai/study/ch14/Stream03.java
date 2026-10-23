package com.korai.study.ch14;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream03 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 2, 10, 30, 22, 33, 50, 53);

        System.out.println(nums.stream().filter(n -> n % 5 == 0).toList());
        System.out.println(nums.stream().map(n -> n % 5 == 0 ? n * 1000 : n).toList());

        System.out.println(new CustomStream<>(nums).filter(n -> n % 5 == 0).toList());
        System.out.println(new CustomStream<>(nums).map(n -> n % 5 == 0 ? n * 1000 : n).toList());
    }
}

@Data
@AllArgsConstructor
class CustomStream<T> {
    private List<T> list; // list라는 List 선언

    public CustomStream<T> map(Function<T, T> fx) { // 자기 자신을 반환하기 위해 클래스명을 자료형으로 사용하고, T를 받아 T를 반환하는 fx를 받는 map 메서드
        List<T> newList = new ArrayList<>(); // newList라는 새로운 ArrayList 생성
        for (T t : list) { // foreach를 사용해 list전체 탐색
            newList.add(fx.apply(t)); // t라는 값을 받아 나온 반환값을 newList에 add
        }
        this.list = newList; // this.list에 newList로 교체
        return this; // 자기 자신을 반환
    }

    public CustomStream<T> filter(Predicate<T> predicate) { // T의 조건이 true, false인지 판단하고 결과로 걸러내는 filter 메서드
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)) {
                newList.add(t); // 참이면 t값을 add
            }
        }
        this.list = newList;
        return this;
    }

    public List<T> toList() {
        return list;
    }
}
