package you.thread;
//suspend 일시정지 메서드, resume 재개, stop 완전 정지
// deprecated 됌 왜냐면 교착상태 데드락을 발생해서
// a가 사용할려는 것을 b가 사용하고 있거나 반대로 b가 사용할려는 것을 a가 사용 중이라 이것이 교착상태
public class ThreadStudy08 {

    public static void main(String[] args) {
        RunImplEx10 th1= new RunImplEx10("*");
        RunImplEx10 th2 = new RunImplEx10("**");
        RunImplEx10 th3 = new RunImplEx10("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend(); // 쓰레드 th1을 잠시 중단.
            Thread.sleep(2000);
            th2.suspend(); // 쓰레드 th2을 잠시 중단.
            Thread.sleep(3000);
            th1.resume(); // 쓰레드 th1을 다시 동작.
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class RunImplEx10 implements Runnable{
    // volatile 은 변수가 쉽게 바뀐다.
    // cpu 에 복사본을 사용안하고 ram 에 원본을 바로 가져다 쓴다
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;

    public RunImplEx10(String name) {
        th = new Thread(this, name);
    }

    void start () {
        th.start();
    }
    void stop () {
        stopped = true;
        th.interrupt(); // 자고있는걸 깨워야 바로 반영 그래야 응답성이 좋음
    }
    void suspend () {
        suspended = true;
        th.interrupt();
        // 자고있는걸 깨워야 바로 반영 그래야 응답성이 좋음
        // suspend 를 호출 했을때 sleep 1 초후 응답 하므로
    }
    void resume () {
        suspended = false;

    }
    @Override
    public void run() {
        while(!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Thread.yield(); // 양보
            }

        }
    }
}
