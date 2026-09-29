package com.korai.study.ch04;

import java.util.Arrays;

public class ArrayMain02 {
    public static void main(String[] args) {
        int[] nums1;
        int[][] nums2;
        int[][][] nums3;

        nums1 = new int[3];
        nums2 = new int[2][3];

//        int[] num3 = nums2[0];
//        System.out.println(Arrays.toString(num3));
//        num3[0] = 100;
//        System.out.println(Arrays.toString(num3));

        nums2[0][0] = 10;
        nums2[0][1] = 20;
        nums2[0][2] = 30;
        nums2[1][0] = 40;
        nums2[1][1] = 50;
        nums2[1][2] = 60;

        int[] num3 = nums2[0];
        System.out.println(Arrays.toString(num3));
        num3[0] = 100;
        System.out.println(Arrays.toString(num3));

        //[] nums4 = new int[] { 10, 20, 30, 40 };
        int[] nums4 = { 10, 20, 30, 40 }; // new int[] 생략 가능하다.
        nums4[0] = 10;
        Arrays.fill(nums4, 100);
        System.out.println(Arrays.toString(nums4));

        int[] nums5 = new int[1000];
        Arrays.fill(nums5, 100);

        int[][] nums0 = new int[2][3];
        int value = 10;

        for (int i = 0; i < nums0.length; i++) {
            for (int j = 0; j < nums0[i].length; j++) {
                nums0[i][j] = value;
                value += 10;

                System.out.print(nums0[i][j] + " ");
            }
            System.out.println();
        }

        run(new int[] { 1, 2, 3 });
    }

    static void run(int[] arr) {

    }

}
