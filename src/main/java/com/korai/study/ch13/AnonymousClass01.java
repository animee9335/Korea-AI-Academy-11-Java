package com.korai.study.ch13;


// 익명 클래스
// 클래스의 이름이 없음.
public class AnonymousClass01 {
    // 오브젝트 클래스를 상속받은 이름없는 클래스를 정의와 동시에 생성
    Object obj = new Object() {};

    class A extends Object{}
    Object obj2 = new A();

    class B {}
    Object obj3 = new B();

    class C {}
    Object obj4 = new C() {}; // C를 상속한 익명 클래스

    abstract class D extends C {} // D는 추상클래스지만 익명클래스를 사용하면 생성 가능
    D obj5 = new D() {};

    interface E {}
    E obj6 = new E() {}; // E를 implement한 익명 클래스
}
