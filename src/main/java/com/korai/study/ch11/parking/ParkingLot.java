package com.korai.study.ch11.parking;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ParkingLot {
    private ArrayList<Car> cars;
    private ArrayList<Car> exitCars;

    private static final int CAPACITY = 10;
    private static int nextNo = 1;
    private int totalSales;
    private int exitCount;

    private Scanner scanner;

    ParkingLot() {
        cars = new ArrayList<>();
        scanner = new Scanner(System.in);
        exitCars = new ArrayList<>();
    }

    // 1.입차
    public void enter() {
        System.out.print("차량번호 > ");
        String carNumber = scanner.nextLine();
        if (carNumber.isEmpty()){
            System.out.println("차량번호를 입력해주세요");
            return;
        }
        System.out.print("차종(1.일반 2.경차) > ");
        boolean compact = "2".equals(scanner.nextLine().trim());

        System.out.print("입차 시각(HH:mm) > ");
        LocalTime entryTime = LocalTime.parse(scanner.nextLine().trim());

        Car car = new Car(0, carNumber, compact, entryTime);

        if (cars.size() == 10) {
            System.out.println("만차입니다. 입차할 수 없습니다.");
        } else {
            car.setNo(nextNo++);
            cars.add(car);
            System.out.printf("[%d번] %s 입차 완료 (남은 자리 %d칸)\n", car.getNo(), car.getCarNumber(), CAPACITY - cars.size());
        }
    }

    // 2.출차
    public Car exit() {

        if (cars.isEmpty()) {
            System.out.println("등록된 차량이 없습니다.");
            return null;
        }

        System.out.print("차량번호 > ");
        String number = scanner.nextLine();
        System.out.print("출차 시각 (HH:mm) > ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        for (int i = 0; i < cars.size() ; i++) {


            if (Objects.equals(cars.get(i).getCarNumber(), number)) {
                long minute = Duration.between(cars.get(i).getEntryTime(), time).toMinutes();
                int fee = FeeCalculator.calculate(minute, cars.get(i).isCompact());

                if (time.isBefore(cars.get(i).getEntryTime())) {
                    System.out.printf("출차 시각이 입차시각(%s)보다 빠릅니다.\n", cars.get(i).getEntryTime());
                    return null;
                }

                System.out.printf("%s | 주차 %d분 | 요금 %,d원\n",cars.get(i).getCarNumber(), minute, fee);
                exitCount++;
                totalSales += fee;
                cars.get(i).setExitTime(time);
                cars.get(i).setParkingFee(fee);
                exitCars.add(cars.get(i));
                return cars.remove(i);
            }
        }
        System.out.println("등록되지 않은 차량입니다.");
        return null;
    }

    public Car findByNumber(String number) {
        for (Car car : cars) {
            if (Objects.equals(car.getCarNumber(), number)) {
                return car;
            }
        }
        return null;
    }

    // 3.주차현황
    public void printAll() {
        if (cars.isEmpty()) {
            System.out.println("등록된 차량이 없습니다.");
        }
        for (Car car : cars) {
            System.out.printf("[%d번] %s | %s | %s 입차\n", car.getNo(), car.getCarNumber(),
                    car.isCompact() ? "경차" : "일반", car.getEntryTime());
        }
        System.out.printf("주차 %d대 / 남은 자리 %d대\n", cars.size(), CAPACITY - cars.size());
    }

    // 4.차량검색
    public void search() {
        System.out.print("검색어 > ");
        String searchNum = scanner.nextLine();

        boolean found = false;
        for (Car car : cars) {
            if (car.getCarNumber().contains(searchNum)) {
                System.out.printf("[%d번] %s | %s | %s 입차\n", car.getNo(), car.getCarNumber(),
                        car.isCompact() ? "경차" : "일반", car.getEntryTime());
                found = true;
            }
        }
        if (!found) {
            System.out.println("검색 결과 없음");
        }
    }

    // 5.오늘매출
    public void total() {
        System.out.printf("출차 %d / 오늘 매출 %d원\n", exitCount, totalSales);
    }

    // 6.출차내역
    public void parkingRecord() {
        if (exitCars.isEmpty()) {
            System.out.println("출차한 차량이 없습니다.");
        }
        for (Car car : exitCars) {
            System.out.printf("[%d번] | %s | 입차 %s | 출차 %s | 요금 %,d원\n", car.getNo(), car.getCarNumber(),
                    car.getEntryTime(), car.getExitTime(), car.getParkingFee());
        }
    }
}
