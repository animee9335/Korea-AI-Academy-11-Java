package com.korai.study.ch09.repository;

import com.korai.study.ch09.entity.Car;

import java.util.List;

public class CarRepository {
    private Long autoIncrement = 1l;
    private final List<Car> carList;

    // CarRepository가 생성되면서 빈 리스트의 주소가 저장된다.
    public CarRepository(List<Car> carList) {
        System.out.println("1");
        this.carList = carList;
    }

    public void insert(Car car) {
        car.setId(autoIncrement++);
        carList.add(car);
    }

    public Car delete(Long id) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId() != id) {
                continue;
            }
            return carList.remove(i);
        }
        return null;
    }

    public void printAll() {
        System.out.println("Car 전체 조회");
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }
}
