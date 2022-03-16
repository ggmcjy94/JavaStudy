package back.multithread;

import javax.swing.*;

public class ThreadStudy {
   //멀티 쓰레드
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
        t.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력 값은 " + input + " 압니다.");
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

        }
    }
}


