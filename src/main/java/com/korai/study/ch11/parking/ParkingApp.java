package com.korai.study.ch11.parking;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();
        Scanner scanner = new Scanner(System.in);
        String cmd;

        System.out.println("===== 코라이 주차장 =====");

        while (true) {
            System.out.println("1.입차 2.출차 3.주차현황 4.차량검색 5.오늘매출 6.출차내역 0.종료");
            System.out.print("선택 > ");
            cmd = scanner.nextLine().trim(); // trim() 입력한 문자열 양 옆의 공백을 제거

            if ("1".equals(cmd)){
                parkingLot.enter();
            } else if ("2".equals(cmd)){
                parkingLot.exit();
            } else if ("3".equals(cmd)){
                parkingLot.printAll();
            } else if ("4".equals(cmd)){
                parkingLot.search();
            } else if ("5".equals(cmd)){
                parkingLot.total();
            } else if ("6".equals(cmd)){
                parkingLot.parkingRecord();
            } else if ("0".equals(cmd)){
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }

        }
    }
}
