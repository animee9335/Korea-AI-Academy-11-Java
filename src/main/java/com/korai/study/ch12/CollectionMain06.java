package com.korai.study.ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionMain06 {
    public static void main(String[] args) {
//        A1.run();
//        A2.run();
//        A3.run();
//        A4.run();

//        A1_1.run();
//        A1_2.run();
        A1_3.run();
        A1_4.run();
        A1_5.run();
    }
}

class A1 {
    static void run() {
        ArrayList<String> strList = new ArrayList<>();
        // 값 추가
        strList.add("데이터1");
        // 값 여러개 한번에 추가 (불변 리스트(상수))
        strList.addAll(List.of("데이터2", "데이터3", "데이터4"));
        strList.addFirst("데이터5");
        strList.addLast("데이터6");
        strList.add(5, "데이터7");
        System.out.println(strList);
    }
}

class A2 {
    static void run() {
        ArrayList<String> strList = new ArrayList<>(List.of("데이터1", "데이터2", "데이터3", "데이터4"));
        boolean isRemoved = strList.remove("데이터2");
        String removedObject = strList.remove(2);
        strList.addAll(List.of("데이터5", "데이터6", "데이터7", "데이터8"));
        strList.removeAll(List.of("데이터6", "데이터7"));
        strList.removeIf(d -> d.contains("3") || d.contains("5")); // 람다식

        System.out.println(isRemoved);
        System.out.println(removedObject);
        System.out.println(strList);
    }
}

class A3 {
    static void run() {
        List<String> strList = List.of("데이터1", "데이터2", "데이터3");
        String data = strList.get(1);
        System.out.println(data);
    }
}

class A4 {
    static void run() {
        List<String> strList = List.of("데이터1", "데이터2", "데이터3");
        boolean isContained = strList.contains("데이터5");
        System.out.println(isContained);

        boolean isContained2 = strList.get(1).contains("2");
        System.out.println(isContained2);
    }
}

class A1_1 {
    static void run() {
        List<Integer> scores = List.of(85, 92, 78, 96, 88);

        double total = 0;
        double avg;
        int max = 0;

        for (int i = 0; i < scores.size(); i++) {
            total += scores.get(i);
            if (scores.get(i) > max) {
                max = scores.get(i);
            }
        }

        avg = total / scores.size();

        System.out.println("전체 점수: " + scores);
        System.out.println("평균: " + avg);
        System.out.println("최고 점수: " + max);
    }
}

class A1_2 {
    static void run() {
        List<String> list = List.of("java", "python", "java", "C++", "python", "Go");
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(newList.contains(list.get(i))) {
                continue;
            }
            newList.add(list.get(i));
        }
        System.out.println(list);
        System.out.println(newList);
    }
}

class A1_3 {
    static void run() {
        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i <  list.size(); i++) {
            if(list.get(i) % 3 == 0) {
                newList.addFirst(list.get(i));
            }
        }
//        System.out.println(list);
        System.out.println(newList);
    }
}

class A1_4 {
    static void run() {
        List<Integer> listA = new ArrayList<>(List.of(5, 2, 8));
        List<Integer> listB = new ArrayList<>(List.of(3, 9, 1));

        listA.addAll(listB);

        // 버블 정렬
        for (int i = 0; i < listA.size() - 1; i++) {
            for (int j = 0; j < listA.size() - 1 - i; j++) {
                if (listA.get(j) >  listA.get(j + 1)) {
                    int temp =  listA.get(j);
                    listA.set(j, listA.get(j + 1));
                    listA.set(j + 1, temp);
                }
            }
        }

//        Collections.sort(listA);
        System.out.println(listA);
    }
}

class A1_5 {
    static void run() {
        List<String> fruits = new ArrayList<>(List.of("사과", "바나나", "포도", "딸기"));

        System.out.println("초기: " + fruits);
        int index = fruits.indexOf("포도");
        System.out.println(index);
        if (index != -1) fruits.set(index, "망고");
        fruits.addFirst("체리");
        fruits.remove("딸기");
//        fruits.removeLast();

        System.out.println("최종: " + fruits);
    }
}
