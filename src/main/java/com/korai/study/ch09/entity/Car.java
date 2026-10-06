package com.korai.study.ch09.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

// 엔티티 클래스 (정보를 저장하는 클래스)
// 생성자, getter, setter, equals, hashCode, toString

@AllArgsConstructor // 모든 인자가 있는 생성자
@Data // getter, setter, equals, hashCode, toString을 포함하고 있다.
public class Car {
    private Long id;
    private String number;
    private String model;
    private String owner;
}
