package you.thread;

public class ThreadStudy01 {

    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

        //멀티 쓰레드 실행 순서는 os 스케줄러가 결정
        t1.start();
        t2.start();
    }
}

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()); // 조상인 thread의 getname()을 호출
        }
    }
}

class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread 를 반환한다.
            System.out.println(Thread.currentThread().getName()); // 조상인 thread의 getname()을 호출
        }
    }
}
