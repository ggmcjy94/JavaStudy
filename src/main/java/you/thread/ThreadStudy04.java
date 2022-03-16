package you.thread;

//쓰레드의 우선순위

public class ThreadStudy04 {
    public static void main(String[] args) {

        ThreadEx6_1  th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();
        // 10 최대 우선순위, //1 최소 우선 순위 //5 보통 우선순위
        // 높을수록 작업이 먼저 끝남 확률 적으로
        th1.setPriority(5);
        th2.setPriority(9);
        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());

        th1.start();
        th2.start();
    }
}

class ThreadEx6_1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x=0; x < 1000000; x++); //시간 지연용 for 문
        }
    }
}

class ThreadEx6_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x=0; x < 1000000; x++);
        }
    }
}
