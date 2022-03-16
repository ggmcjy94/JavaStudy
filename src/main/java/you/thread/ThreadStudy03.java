package you.thread;

import javax.swing.*;

//쓰레드의 I/O 블락킹
public class ThreadStudy03 {
    public static void main(String[] args) {
        //싱글 쓰레드 이러면 사용자가 입력 할때까지 쓰레드가 막혀 있다 이것이 input output 블락킹
//        String input = JOptionPane.showInputDialog("아무 값이나 입력하세여.");
//        System.out.println("입력하신 값은 " + input + "입니다.");
//
//        for (int i = 10; i > 0; i--) {
//            System.out.println(i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //멀티쓰레드 로 할시에는 사용자한테 입력 받기전 까지도 쓰레드가 실행됨
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세여.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}
class ThreadEx7_1 extends Thread{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
