package com.korai.study.ch09.service;

import com.korai.study.ch09.repository.CarRepository;

import java.util.ArrayList;

public class InitService implements Runnable {
    private static CarRepository carRepository;

    public InitService() {
        // 중간에 한번 더 실행되도 문제없이 진행된다.
        if ( carRepository == null) {
            run();
        }
    }

    @Override
    public void run() {
        System.out.println("프로그램 초기 설정 시작...");
        carRepository = new CarRepository(new ArrayList<>()); // 빈 리스트 생성 -> new CarRepository 실행
        System.out.println("프로그램 초기 설정 완료");
    }

    // getCarRepository()을 통해 CarRepository에 접근
    public static CarRepository getCarRepository() {
        return carRepository;
    }
}
