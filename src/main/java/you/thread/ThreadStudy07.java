package you.thread;

import javax.swing.*;

// interrupt 대기 상태인 쓰레드를 실행대기 상태로 만듦 //자는걸 깨우거나 다른 쓰레드가 하는걸 멈추게 한다.
public class ThreadStudy07 {

    public static void main(String[] args) {
        ThreadEx9_1 th1 = new ThreadEx9_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력 바람");
        System.out.println("입력하신 값은 " +input + "입니다.");
        th1.interrupt(); // interrupt() 를 호출하면 interrupted 상태가 true 가 된다.
        System.out.println("isInterrupted(): " + th1.isInterrupted()); //true
    }
}

class ThreadEx9_1 extends Thread{
    @Override
    public void run() {
        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 250000000L; x++); //시간 지연
        }
        System.out.println("isInterrupted(): " + this.isInterrupted()); //true
        System.out.println("isInterrupted(): " + this.isInterrupted()); //true
        //is Interrupted()와 달리 interrupted()는 interrupted 상태변수를 false 로 초기화 함
        System.out.println("Interrupted(): " + Thread.interrupted()); //true 스택틱임
        System.out.println("Interrupted(): " + Thread.interrupted()); //false
        System.out.println("카운터가 종료 되었습니다.");
    }
}
