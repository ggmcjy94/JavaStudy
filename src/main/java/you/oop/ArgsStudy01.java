package you.oop;

//기본형 매개변수 - 변수의 값을 읽기만 할 수 있다 (read only)
//참조형 매개변수 - 변수의 값을 읽고 변경할 수 있다(read & write)
public class ArgsStudy01 {

    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);
        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
    }

    static void change(int x) { // cm // 기본형 매개변수
        x = 1000; // lv
        System.out.println("change() : x = " + x);
    }
}

class Data {
    int x; //iv
}
