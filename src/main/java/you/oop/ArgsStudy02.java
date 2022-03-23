package you.oop;

//참조형 매개변수 - 변수의 값을 읽고 변경할 수 있다(read & write)
public class ArgsStudy02 {

    public static void main(String[] args) {
        Data2 d = new Data2();
        d.x = 10;
        System.out.println("main() : x = " + d.x);
        change(d);
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x); // 1000;
    }

    static void change(Data2 d) { // cm // 참조형 매개변수
        d.x = 1000; // lv
        System.out.println("change() : x = " + d.x);
    }
}

class Data2 {
    int x; //iv
}
