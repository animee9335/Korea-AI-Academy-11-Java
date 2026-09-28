package com.korai.study.ch03;

// 클래스 영역(클래스 로딩에 대한 이해)
public class MethodArea {
    public static void main(String[] args) {
        /*
        TestObject test1;                    선언만 함, 생성자 호출X, 지역 변수이므로 초기화하지 않은 채 사용하면 컴파일 에러
        TestObject test2 = new TestObject(); 선언 + 객체 생성 + 참조 대입, 생성자 호출O, 그 객체의 주소(참조)가 b에 저장
        */

        TestObject a = new TestObject();
        TestObject.name = "빵";
        a.name = TestObject.name;
        System.out.println(TestObject.name);
        System.out.println(a.name);

        TestObject.name = "빠앙";

        TestObject b = new TestObject();
        TestObject.name = b.name;
        System.out.println(b.name);

    }
}

class TestObject{
    static String name; // 클래스 변수: 클래스당 딱 하나, 객체없이 호출할 수 있다. 공용 데이터
    int age;            // 인스턴스 변수: 객체마다 하나씩

    public TestObject(){
        System.out.println("생성자 호출");
    }

    static {
        System.out.println("스태틱 호출");
    }
}
