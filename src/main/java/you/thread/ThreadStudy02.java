package you.thread;

/**
 * 실행중인 사용자 쓰레드가 하나도 없을 때 프로그램은 종료된다.
 */

public class ThreadStudy02 {
    static long startTime = 0;
    public static void main(String[] args) {
        ThreadEx11_1 th1 = new ThreadEx11_1();
        Runnable r = new ThreadEx11_2();
        Thread th2 = new Thread(r);
        startTime = System.currentTimeMillis();

        // th1 에서 th2로 th2 에서 th1 으로 갈때 context switching 이 발생함
        // 그래서 싱글 쓰레드 에서 돌릴 떄보다 시간이 더걸린다
        th1.start();
        th2.start();

        try {
            th1.join(); //main 쓰레드가 th1쓰레드의 작업이 끝날 때까지 기다린다.
            th2.join(); //main 쓰레드가 th2쓰레드의 작업이 끝날 때까지 기다린다.
        } catch (InterruptedException e) {}


        System.out.print("소요시간: " + (System.currentTimeMillis() - startTime)+" 초");
    }
}

class ThreadEx11_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <300; i++) {
            System.out.print("-");
        }
    }
}


class ThreadEx11_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <300; i++) {
            System.out.print("|");
        }
    }
}