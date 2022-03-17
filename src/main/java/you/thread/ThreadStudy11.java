package you.thread;

import java.util.ArrayList;

//동기화를 하면 프로그램의 효율이 떨어진다 이걸 방안 하고자 wait , notify 가 나옴
//wait
//동기화의 효율을 높이기 위해 wait() notify()를 사용
//Object 클래스에 정의 되어 있으며 동기화 불록 내에서만 사용할 수 있다.
// wait() 객체의 lock 을 풀고 쓰레드를 해당 객체의 waiting pool 에 넣는다.
// notify() waiting pool 에서 대기중인 쓰레드 중의 하나를 깨운다.
// notifyAll() waiting pool 에서 대기중인 모든 쓰레드를 깨운디.
public class ThreadStudy11 {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();
        new Thread(new Cook(table), "COOK").start();
        new Thread(new Custom(table, "donut"), "CUST1").start();
        new Thread(new Custom(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);

    }
}

class Custom implements Runnable {
    private Table table;
    private String food;

    public Custom(Table table, String food) {
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
            if (eatFood()) System.out.println(name + " ate a " + food);
            else System.out.println(name + " failed to eat. :(");
        }
    }
    boolean eatFood() {
        return table.remove(food);
    }
}

class Cook implements Runnable {

    private Table table;

    public Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Table {

    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if (dishes.size() >= MAX_FOOD) {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes:" + dishes);
    }
    public boolean remove(String dishName) {
        synchronized (this) {
            while (dishes.size() == 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int dishNum() {
        return dishNames.length;
    }
}

// 문제점 음식이 없을때 손님이 Table의 lock 을 쥐고 안놓는다.
// 요리사가 lock 을 얻지못해서 table에 음식을 추가할 수 없다.

