package com.korai.study.ch13;

import java.util.function.*;

// 내장형 람다 인터페이스
public class Lambda03 {
    public static void main(String[] args) {
        Runnable runnable = () -> {}; // 매개변수 X, 리턴값 X
        Supplier<Integer> supplier = () -> 100; // 매개변수 X, 리턴값 O, 제네릭이 없으면 Objects
        Consumer<String> consumer = str -> {}; //  매개변수 O, 리턴값 X
        Function<Integer, String> function = num -> Integer.toString(num); // 매개변수 O, 리턴값 O <매개변수 자료형, 리턴값 자료형>
        Predicate<Integer> predicate = num -> num % 2 == 0; // 매개변수 O, true, false를 반환한다.

        runnable.run();
        int r1 = supplier.get();
        consumer.accept("Hello");
        String r2 = function.apply(10);
        boolean r3 = predicate.test(100);


        // Binary를 추가해서 매개변수를 2개로 사용할 수 있게한다.
        BiConsumer<String, Integer> consumer2 = (str, num) -> {};
        BiFunction<Integer, Integer, String> function2 = (num1, num2) -> Integer.toString(num1);
        BiPredicate<Integer, Integer> predicate2 = (num1, num2) -> num1 % num2 == 0;

        System.out.println(predicate2.and((num1, num2) -> num1 > num2).test(10, 2));


    }
}
