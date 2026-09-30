package com.korai.study.ch05.practice;

public class Practice01 {
    /*

    1)
    결과 : B


    2)
    결과 : A
          B
    이유 : 첫번째 if (x > 3)이 먼저 실행되고, 두 번째 if(x > 4) ... else ... 가 실행된다.


    3)
    결과 : Y


    4)
    이유 if (n = 3)에서 n = 3은 n에 3을 대입하는 대입연산자이기 때문에 같다 의미인 n == 3이 들어가야한다.


    5)
    결과 : B
    &&는 좌측을 검사했을 때 false면 우측 검사는 넘어가지만 &는 좌측 검사 후 무조건 우측 검사를 한다.
    조건식에 문제가 없으면 정상적으로 작동하고 결과도 같지만, 좌측 검사 후 우측 조건에 문제가 있는 경우 에러가 생길 수 있다.


    6)
    int n = 2;
    if (n % 2 == 0) System.out.println("짝수");
    else System.out.println("홀수");


    7)
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)


    8)
    결과 : 다르다
           같다


    9)
    int a = 6;
    int b = 4;
    int c = 3;

    void maxValue(int a, int b, int c) {
    if (a > b && a > c) System.out.println(a);
    else if (b > a && b > c) System.out.println(b);
    else System.out.println(c);
    }

    10)
    결과 : 11000 비쌀
     */
}
