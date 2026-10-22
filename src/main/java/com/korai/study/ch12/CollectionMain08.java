package com.korai.study.ch12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionMain08 {
    public static void main(String[] args) {
        // Map
        Map<String, String> productMap = new HashMap<>();
        productMap.put("productName", "상품1");
        productMap.put("price", "가격");
        productMap.put("createdAt", "2026-10-19");

        System.out.println(productMap);
        System.out.println(productMap.get("price"));

        Map<String, Object> student = new LinkedHashMap<>(); // 삽입한 순서대로 출력
        student.put("name", "장서현");
        student.put("age", 29);
        student.put("gender", true);

        System.out.println(student);
        System.out.println(student.get("age"));

    }
}
