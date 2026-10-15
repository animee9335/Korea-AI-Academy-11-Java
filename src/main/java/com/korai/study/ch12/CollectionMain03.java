package com.korai.study.ch12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

public class CollectionMain03 {

    @Data
    @AllArgsConstructor
    static class Car {
        private String model;
    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 100;
        nums[1] = 200;
        nums[2] = 300;
        nums[3] = 400;
        nums[4] = 500;

        String[] names = { "일일일", "이이이", "삼삼삼", "사사사" };

        Car[] cars = new Car[5];
        cars[0] = new Car("아반떼");
        cars[1] = new Car("쏘나타");
        cars[2] = new Car("그랜저");
        cars[3] = new Car("G80");
        cars[4] = new Car("G90");

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(names));
        print(nums);
        print(names);
        print(cars);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    static void print(String[] str) {
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println();
    }

//    static void print(Car[] car) {
//        for (Car c : car) {
//            System.out.println(c);
//        }
//        System.out.println();
//    }

//    static void print(Object[] car) {
//        for (int i = 0; i < car.length; i++) {
//            System.out.println(car[i]);
//        }
//        System.out.println();
//    }

    static void print(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            System.out.println(car[i].model);
        }
        System.out.println();
    }
}