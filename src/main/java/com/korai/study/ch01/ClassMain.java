package com.korai.study.ch01;

public class ClassMain {
    public static void main(String[] args) {
        // [ 변수와 자료형 ]
        int num = 10; // 일반 자료형
        final double PI = 3.14; // 상수(final)
        String name = "장서현"; // 참조 자료형


        class Student {
            String name;
            int age;
        }

        Student s1 = new Student();
        s1.name = "장서현";
        s1.age = 29;

        class Student2 {
            String name;
            Object age; // Object는 모든 자료형을 담고 있지만, 그 자료형만의 특징이 사라진다.
        }

        Student2 s2 = new Student2();
        s2.age = s1;

        Student2 s22 = new Student2();
        s22.age = "29";

        System.out.println("29" + 29);
        // System.out.println(s22.age + 29); Object 자료형이기 때문에 + 연산이 불가능하다. (자료형만의 특징이 사라졌기 때문)
        // System.out.println((String) s22.age + 29); // 다운캐스팅을 통해 형변환을 해야 연산 가능하다.

        class Student3<A> {
            String name;
            A age;
        }

        Student3<String> s3 = new Student3<String>(); // new Student3<>(); String 생략 가능
        Student3<Integer> s33 = new Student3<>();

        s3.age = "29";
        s33.age = 29;

        System.out.println(s3.age + s33.age); // generic을 했기 때문에 다운캐스팅이 필요없어 연산 가능

        int n1 = 1;
        int n2 = n1; // 같은 자료형만 대입이 가능하다.
        // Student3<String> s333 = s33; s33은 int자료형이기 때문에 대입이 불가능하다.
        Student3<?> s333 = s3; // <?> 어떤 타입으로 들어갈 지 자동으로 인식, generic의 와일드카드
    }
}

/*

    [ 클래스 ]

    클래스는 설계도, 객체는 그 설계도로 찍어낸 실물
    설계도는(Student.class)는 한 장뿐, 실물(객체)은 new 할 때마다 하나씩 새로 생긴다.
    * 객체 = 인스턴스(Instance)

    Method Area (클래스 영역)
    - 클래스 정보, 메서드 코드, static 변수
    생김 : 클래스를 처음 쓸 때
    사라짐 : 보통 프로그램 끝까지

    Stack (호출 스택)
    - 메서드 호출마다 쌓이는 프레임, 지역 변수, 매개 변수
    생김 : 메서드를 호출할 때
    사라짐 : 메서드가 끝나는 즉시

    Heap (힙)
    - new로 만든 모든 객체와 그 필드
    생김 : new 할 때
    사라짐 : 아무도 안 가리키면 GC(가비지 컬렉션)가 수거

    boolean 값의 기본값은 false이다.

    예외 처리는 중요하다. 로그도 꼭 남길 것

    public, private, protected, default
*/