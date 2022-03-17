package you.lamda;

// 1. 매개 변수가 하나인 경우, 괄호() 생략가능 (타입이 없을때 만)
// 람다식은 익명 함수가 아니라 익명 객체이다.
public class LamDaStudy01 {
    public static void main(String[] args) {
//        Object obj = (a, b) -> a > b ? a : b; // 람다식. 익명 객체
        Object obj = new Object() {
            int max(int a, int b) {
                return Math.max(a, b);
            }
        }; // 위에랑 같은거

//        int value = obj.max(3, 5); // 함수형 인터페이스
    }




}
