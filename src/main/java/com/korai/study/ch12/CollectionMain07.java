package com.korai.study.ch12;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionMain07 {
    public static void main(String[] args) {
        // Set, 중복을 제거한 리스트
//        Set<Integer> nums = new HashSet<>(); hash값에 대해 정렬하여 값이 순서대로 출력되지 않는다.
        Set<Integer> nums = new TreeSet<>(); // 트리에 의한 정렬로 Hash와 다르게 정렬(오름차순)되어 추가된다. 정렬과 탐색이 이루어져야해 상대적으로 속도는 느리다.
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);
        nums.add(60);
        nums.add(70);
        nums.add(80);
        nums.add(80);

        System.out.println(nums.contains(80));
        System.out.println(nums.containsAll(List.of(30, 50, 700))); // 내부에 원하는 값이 있는지 찾는 것이 용이하다.

        List<String> names = new ArrayList<>(List.of(
                "일일일",
                "이이이",
                "일일일",
                "일일일",
                "이이이"));

        Set<String> nameSet = new HashSet<>(names);
        nameSet.addAll(names);
        System.out.println(nameSet);

        @AllArgsConstructor
        class Student {
            String name;
            String adress;
        }

        List<Student> students = new ArrayList<>(List.of(
                new Student("일일일", "서울"),
                new Student("일일일", "부산"),
                new Student("이이이", "서울"),
                new Student("이이이", "경남"),
                new Student("삼삼삼", "경남")
        ));

        Set<String> addressSet = new HashSet<>();

        for (Student student : students) {
            addressSet.add(student.adress);
        }

        System.out.println(addressSet);
        System.out.println(students.stream().map(s -> s.adress).collect(Collectors.toSet()));

        for (String address : addressSet) {
            System.out.println(address);
        }

        Iterator<String> addr = addressSet.iterator();
        while (addr.hasNext()) {
            System.out.println(addr.next());
        }




    }
}
