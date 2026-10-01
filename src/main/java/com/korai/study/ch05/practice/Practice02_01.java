package com.korai.study.ch05.practice;

public class Practice02_01 {
    public static void main(String[] args) {
        /*
        * 구구단
        * [ 2단 ]
        * 2 x 1 = 2   2 x 2 = 4
        * 2 x 3 = 6   2 x 4 = 8
        * ...
        *
        * [ 3단 ]
        * 3 x 1 = 3   3 x 2 = 6
        * ...
        *
        * [ 9단 ]
        * ...
        * */

//        for (int i = 0; i < 8 ; i++) {
//            System.out.println("[ " + (i + 2) + "단 ]");
//            for (int j = 0; j < 9; j++) {
//                if ( (j + 1) % 3 == 0 )
//                    System.out.print((i + 2) + " x " + (j + 1) + " = " + (i + 2) * (j + 1) + "\n");
//                else
//                    System.out.print((i + 2) + " x " + (j + 1) + " = " + (i + 2) * (j + 1) + "\t");
//            }
//        }

        String gugudanString = "";
        int[][][] gugudanArray = new int[8][9][3];
        for (int i = 0; i < gugudanArray.length; i++) {
            int dan = i + 2;
            gugudanString += "[ " + dan + "단 ]\n";
            for (int j = 0; j < gugudanArray[i].length; j++) {
                int num = j + 1;
                int result = dan * num;
                gugudanArray[i][j][0] = dan;
                gugudanArray[i][j][1] = num;
                gugudanArray[i][j][2] = result;
                gugudanString += String.format("%d x %d = %d%s", gugudanArray[i][j][0], gugudanArray[i][j][1],
                        gugudanArray[i][j][2], gugudanArray[i][j][1] % 3 == 0 ? "\n" : "\t");
            }
        }
        System.out.println(gugudanString);
    }
}

