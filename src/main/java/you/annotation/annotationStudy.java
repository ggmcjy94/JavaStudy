package you.annotation;

class Parent {
    void parentMethod(){}

    void parentMethod2(){}
}

class Child extends Parent {
    @Override // 실수 했는지 알려줌
    void parentMethod() {
        System.out.println("1");
    }
    @Deprecated
    @Override
    void parentMethod2() {
        System.out.println("2");
    }
}
@FunctionalInterface //함수형 인터페이스는 하나의 추상 메서드만 가능
interface Testable {
    void  test(); //추상 메서드
//    void  check();
}


public class annotationStudy{
//    @SuppressWarnings({"unchecked","deprecation"}) // 경고를 억제 하는것
    public static void main(String[] args) {
        Child c = new Child();
        c.parentMethod();
        c.parentMethod2();

    }

}
