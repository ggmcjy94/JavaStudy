package you.thread;

import static you.thread.ThreadStudy06.delay;

// sleep static void
public class ThreadStudy06 {
    public static void main(String[] args) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();
        th1.start();
        th2.start();

        delay(2000);

        System.out.println("<<main 종료>>");
    }

    static void delay(long millis) {
        try {
            Thread.sleep(millis);
//            th1.sleep(2000); //이러면 안됌 작동은 하지만 결국에는 main method 내에 있어
//            Main Thread 를 재우는 것이므로 오해의 소지가 있음
        } catch (InterruptedException e) {}
    }
}


class ThreadEx8_1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) System.out.print("-");
//        delay(2000);
        System.out.print("<<th1 종료>>");
    }
}


class ThreadEx8_2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) System.out.print("|");
        System.out.print("<<th2 종료>>");
    }
}