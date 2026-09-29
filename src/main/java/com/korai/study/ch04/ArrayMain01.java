package com.korai.study.ch04;

public class ArrayMain01 {
    public static void main(String[] args) {
        byte[] a1 = new byte[4];
        short[] a2 = new short[4];
        int[] a3 = new int[4];  // new로 할당하는 순간 크기는 고정되고, 크기를 바꾸려면 다른 빈 배열을 할당하고 옮겨야한다.

        a1 = new byte[5];
        a1 = null;
        int num = 10;
        num = 0;

        class Student {
            String name;
            double[] scores;
        }

        Student s = new Student();
        s.name = "장서현";
        s.scores = new double[3];
        s.scores[0] = 10.0;

        Student[] s1 =  new Student[4];
        for(int i = 0; i < s1.length; i++) {
            s1[i] = new Student();

            s1[i].name = "빵" + i;
            System.out.println(s1[i].name);
        }

        Student[] s2 = s1;
        s2[0] = s;
        s2[1].scores = new double[3];
        s2[1].scores[0] = 40.0;

        System.out.println(s2[0].name);
        System.out.println(s2[1].name);
        System.out.println(s2[0].name + " " + s2[0].scores[0] + "점");
        System.out.println(s2[3].name + " " + s2[0].scores[1] + "점");
        System.out.println(s2[0].scores[0] + "점");
        System.out.println(s2[1].name +  " " + s2[1].scores[0]);
        System.out.println(s2[1].name +  " " + s2[1].scores[1]);

    }
}
