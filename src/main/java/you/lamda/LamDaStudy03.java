package you.lamda;


public class LamDaStudy03 {
    static void execute(MyFunction2 f) {
        f.run();
    }

    static MyFunction2 getMyFunction() {
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        MyFunction2 f2 = new MyFunction2() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction2 f3 = () -> System.out.println("f3.run");

        f2.run();
        f3.run();

        execute(() -> System.out.println("f1.run()"));
        execute(() -> System.out.println("run()"));

        getMyFunction().run(); // f3.run()

    }
}

interface MyFunction2 {
    void run();
}
