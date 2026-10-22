package com.korai.study.ch12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;

public class CollectionMain09 {
    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        class Student {
            private String name;
            private String adress;
        }

        List<Map<String, Map<String, Map<String, Object>>>> data = List.of(
                Map.of("class1", Map.of(
                        "student1", Map.of(
                                "id", 1,
                                "object", new Student("일일일", "서울"),
                                "createdAt", LocalDate.of(2025, 1, 1)
                        ),
                        "student2", Map.of(
                                "id", 2,
                                "object", new Student("이이이", "서울"),
                                "createdAt", LocalDate.of(2025, 1, 1)
                        ),
                        "student3", Map.of(
                                "id", 3,
                                "object", new Student("삼삼삼", "서울"),
                                "createdAt", LocalDate.of(2025, 1, 1)
                        )
                )),
                Map.of("class2", Map.of(
                        "student1", Map.of(
                                "id", 4,
                                "object", new Student("일일일", "부산"),
                                "createdAt", LocalDate.of(2026, 1, 1)
                        ),
                        "student2", Map.of(
                                "id", 5,
                                "object", new Student("이이이", "부산"),
                                "createdAt", LocalDate.of(2026, 1, 1)
                        ),
                        "student3", Map.of(
                                "id", 6,
                                "object", new Student("삼삼삼", "부산"),
                                "createdAt", LocalDate.of(2026, 1, 1)
                        )
                ))
        );

//        System.out.println(data);
//        System.out.println(data.get(0).get("class1"));
//        System.out.println(data.get(0).get("class1").get("student1"));
//        System.out.println(data.get(1).get("class2").get("student2").get("id"));

        // Object로 업캐스팅 되어 있기때문에 다운캐스팅이 필요
//        System.out.println(((Student) data.get(1).get("class2").get("student1").get("object")).getName());

        for (int i = 0; i < data.size(); i++) {
            Set<String> keySet = data.get(i).keySet();
            for (String key : keySet) {
                Map<String, Map<String, Object>> studentMap = data.get(i).get(key);
                Set<String> studentKeySet = studentMap.keySet();
                for (String studentKey : studentKeySet) {
                    Map<String, Object> student = studentMap.get(studentKey);
                    Student s = (Student) student.get("object");
                    System.out.println(s.getName());
                }
            }
        }

        for (int i = 0; i < data.size(); i++) {
            Set<Map.Entry<String, Map<String, Map<String, Object>>>> entries = data.get(i).entrySet();
            for (Map.Entry<String, Map<String, Map<String, Object>>> entry : entries) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
        }

        Map<String, Integer> ages = Map.of(
                "일일일", 29,
                "이잉", 30,
                "삼", 31
        );

        // Entry를 통해 Key와 Value를 get으로 가져올 수 있게한다.
        Set<Map.Entry<String, Integer>> entries = ages.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        entryList.addAll(entries);
        System.out.println(entryList.get(0));
        System.out.println(entryList.get(1));
        System.out.println(entryList.get(2));

    }
}
