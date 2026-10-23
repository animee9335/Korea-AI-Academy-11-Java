package com.korai.study.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {
        // 반복작업을 하나의 라이브러리로 구조화 해둔 것
        Stream<Integer> numStream = Stream.of(10, 20, 30, 40, 50);
        System.out.println(numStream);
//        System.out.println(numStream.toList());
        System.out.println(numStream.map(num -> num * 10).toList());

        Integer[] intArray = {1, 2, 3, 4, 5};

        System.out.println(Arrays.stream(intArray)
                .map(num -> {
                    if (num % 4 == 0) return num * 10;
                    return num;
                })
                .toList());

        Function<Integer, Integer> fx = num -> num * 10;

        print(fx);
        print(num -> num * 20);

        // List나 Array처럼 원본이 남는게 아닌 Stream은 연산 후 새 Stream에 담기때문에 기존 Stream에 남지 않는다.
        // 리턴이 Stream이면 중간연산 이외에는 최종연산이다.
        List<String> names = List.of("일일일", "이이이", "삼삼삼");
        Stream<String> namesStream = names.stream(); // 생성
        Stream<String> namesStream2 = namesStream.map(n -> n + "님"); // 중간연산
        Stream<String> namesStream3 = namesStream2.map(n -> "이름: " + n); // 중간연산
        Stream<String> namesStream4 = namesStream3.filter(name -> !name.contains("일"));
        List<String> newNames = namesStream4.toList(); // 최종연산

        System.out.println(newNames);

        System.out.println(names.stream().map(n -> n + "님")
                .map(n -> "이름: " + n)
                .filter(name -> !name.contains("삼"))
                .toList());


    }

    static void print(Function<Integer, Integer> a) {
        System.out.println(a.apply(5));
    }
}
