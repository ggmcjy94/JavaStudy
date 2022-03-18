package you.oop;

public class Test03 {

    public static void main(String[] args) {
        InitTest2 i = new InitTest2();
        System.out.println(InitTest2.cv);
        System.out.println(i.iv);
    }

}

class InitTest{
    int x;
    int y =x; // 인스턴스 생성시 자동 초기 화 0

    void testInit() {
        int i;
//        int j = i; 지역변수는 수동 초기화 시켜야됌
    }

}

class InitTest2{
    static int cv = 1; // 명시적 초기화
    int iv = 1;// 명시적 초기화
    static {cv = 2;} // 클래스 초기화 블럭
    {iv = 2;} //인스턴스 초기화 블록
    InitTest2() { // 생성자
        iv = 3;
    }
}
class StaticBlock {
    static int[] arr =new int[10]; // 명시적 초기화
    static { //클래스 초기화 블록 - 배열 arr 을 난수로 채운다 // cv 초기화
        for(int i=0; i<arr.length; i++) {
            arr[i] = (int)(Math.random()*10)+1;
        }
    }
}
