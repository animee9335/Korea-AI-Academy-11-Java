package com.korai.study.ch11.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;


@Data
public class Car {
    private int no;
    private String carNumber;
    private boolean compact;
    private LocalTime entryTime;
    private LocalTime exitTime;
    private int parkingFee;

    public Car(int no, String carNumber, boolean compact, LocalTime entryTime) {
        this.no = no;
        this.carNumber = carNumber;
        this.compact = compact;
        this.entryTime = entryTime;
    }

    public Car(int no, String carNumber, boolean compact, LocalTime entryTime, LocalTime exitTime, int parkingFee) {
        this.no = no;
        this.carNumber = carNumber;
        this.compact = compact;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingFee = parkingFee;
    }
}

