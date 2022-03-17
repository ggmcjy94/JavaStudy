package you.thread;

import java.util.ArrayList;

// 해결책 음식이 없을떼 wait() 으로 손님이 lock을 풀고 기다리게 하자
// 요리사가 음식을 추가하면 notify() 로 손님에게 알리자 (손님이 lock을 재획득)
public class ThreadStudy12 {

    public static void main(String[] args) throws InterruptedException {
        Table2 table = new Table2();
        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Custom2(table, "donut"), "CUST1").start();
        new Thread(new Custom2(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);

    }
}

class Custom2 implements Runnable {
    private Table2 table;
    private String food;

    public Custom2(Table2 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

class Cook2 implements Runnable {

    private Table2 table;

    public Cook2(Table2 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            System.out.println("idx = " + idx);
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Table2 {

    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait(); //COOk 쓰레드를 기다리게 한다.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dishes.add(dish);
        notify();// 기다리고 있는 CUST를 꺠우기 위함
        System.out.println("Dishes: " + dishes.toString());
    }
    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting");
                try {
                    wait(); // CUST 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify(); // 잠자고 있는 Cook 을 꺠우기 위함
                        return;
                    }
                }
                try{
                    System.out.println(name + " is waiting.");
                    wait(); // 원하는 음식이 없는 CUST 쓰레드를 기다리게 한다
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        }
    }
    public int dishNum() {
        return dishNames.length;
    }
}
