package you.oop;

import java.util.ArrayList;

public class Test02 {

    public static void main(String[] args) {
        //객체 생성 없이 사용가능
        System.out.println(MyMath.add(200L, 100L)); // 클래스 메서드 호출
        MyMath m = new MyMath(); //인스턴스 생성
        m.a = 200L;
        m.b = 100L;
        System.out.println(m.add()); // 인스턴스 메서드 호출 참조변수.메서드;
        System.out.println(m.division());
    }
}
// 객체 = 인스터스 변수 들의 집합체;
// 왜 스태틱 메서드는 인스턴스 멤버를 쓸수 없나요
// static 메서드 호출시 객체(iv 묶음) 가 없을 수도 있어서
class MyMath {
    long a, b; // iv
    ArrayList<Long> l = new ArrayList<>(); // iv

    int size() { //im
        l.add(a);
        l.add(b);
        return l.size();
    }

    long add() { // 인스턴스 메서드
        return a + b; // iv 사용가능
    }

    //iv 를 사용하지않을때 붙인다. static 을 붙인다.
    static long add(long a, long b) { // 클래스 메서드 (static 메서드) //cm
        return a + b; // iv 사용 불가 (파라미터) 지역변수 정의 후 사용가능
    }

    long division() {
        return add() / size() ; // instance 메서드 사용이라 static 붙히면 안됨;
    }

}