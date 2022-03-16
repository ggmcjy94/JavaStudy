package you.thread;

// 데몬 쓰레드 (보조 쓰레드)
// 일반 쓰레드를 보조 해주는 쓰레드
// 일반 쓰레드가 모두 종료되면 자동적으로 종료 된다.
// 쓰레드 실행 제어 메서드
// sleep 재우기 join 다른 쓰레드 기다리기 , interrupt 깨우기 , suspend 일시정지
// resume 재개 , yield 양보
public class ThreadStudy05 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) { //main 쓰레드
        Thread t = new Thread(new ThreadStudy05());
        t.setDaemon(true); //이부분이 없으면 종료 되지 않음
        t.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 5) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");

    }

    @Override
    public void run() {
        while (true) { // 무한 루프 인데도 보조역할(데몬쓰레드)이다 보니 일반쓰레드 가 종료 되니 같이 종료
            try{
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (autoSave) autoSave();
        }
    }

    private void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}

