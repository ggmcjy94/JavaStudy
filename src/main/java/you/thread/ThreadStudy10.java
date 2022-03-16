package you.thread;

// 쓰레드의 동기화
// 멀테 쓰레드 프로세스에서는 다른 쓰레드의 작업에 영향을 미칠 수 있다.
// 진행중인 작업이 다른 쓰레드에게 간섭받지 않게 하려면 동기화가 필요
// 쓰레드 동기화 - 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하게 막는 것
// 동기화하려면 간섭받지 않아야 하는 문장들을 임계 영역으로 설정
// 임계영역은 락을 얻은 단 하나의 쓰레드만 출입가능 (객체 1개에 락 1개)
// synchronized 를 이용한 동기화
//synchronized 로 임계영역 을 설정 하는 방법 2가지
// 1 메서드 전체를 임계 영역으로지정
// public synchronized void calcSum() {} // 임계영역 1번에 1쓰레드
// 2 특정한 영역을 임계 임계 영역으로 지정
// synchronized(객체의 참조변수) {} // 임계영역
public class ThreadStudy10 {

    public static void main(String[] args) {
        Runnable r = new RunnableEx22();
        //synchronized 는 한번에 한 쓰레드만 들어가게
        new Thread(r).start(); // ThreadGroup 에 의해 참조되므로 gc 대상이 아니다.
        new Thread(r).start(); // ThreadGroup 에 의해 참조되므로 gc 대상이 아니다.

    }
}

class Account2 {
    private int balance = 1000; //private 으로 해야 동기화가 의미가 있다.

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= money;
        }
    }
}

class RunnableEx22 implements Runnable {
    Account2 acc = new Account2();
    @Override
    public void run() {
        while (acc.getBalance() > 0) { // synchronized 때문에 절대로 음수가 안나옴
            //100 , 200 , 300 ,중의 한 값을 앞으로 선택해서 출금
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println(Thread.currentThread().getName()+" balance: " + acc.getBalance());
        }
    }
}
