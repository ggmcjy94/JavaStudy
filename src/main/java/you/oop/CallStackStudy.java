package you.oop;
// 호출 스택
// 메서드 수행에 필요한 메모리가 제공되는 공간
// 메서드가 호출되면 호출스택에 메모리 할당, 종료되면 해제
public class CallStackStudy {
    //main -> println -> println -> main
    //순으로 쌓이고 실행되고 종료
    public static void main(String[] args) { //
        System.out.println("println");
    }
}
