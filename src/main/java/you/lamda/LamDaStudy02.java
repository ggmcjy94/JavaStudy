package you.lamda;

//함수형 인터페이스
// 함수형 인터페이스 - 단 하나의 추상 메서드만 선언된 인터페이스

public class LamDaStudy02 {

    public static void main(String[] args) {
        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        int value = f.max(3, 5);
        System.out.println("value = " + value);

        // 람다식(익명객체) 을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
        MyFunction f2= (a, b) -> a > b ? a : b;
        int value2 = f2.max(3, 5);
        System.out.println("value2 = " + value2);


        MyFunction f3= Math::max;
        int value3 = f3.max(3, 5);
        System.out.println("value3 = " + value3);


    }
}

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야함
interface MyFunction {
    public abstract int max (int a , int b);
}
