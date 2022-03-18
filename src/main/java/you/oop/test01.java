package you.oop;

public class test01 {
    int iv;
    static int cv;

    void method() {
        int lv = 0;
        System.out.println(cv);
        System.out.println(iv);
    }

    public static void main(String[] args) {
        test01 t = new test01();
        t.iv = 3;
        cv = 3;
        t.method();
    }
}

class Card {
    String kind;
    int number;

    static int width = 100;
    static int height = 250;
}
