package you.oop;


public class InstanceOfStudy2 {

    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv1()); // Product 자손들을 넣음
        b.buy(new Computer()); // Product 자손들을 넣음

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다");
        System.out.println("현재 보너스점수는 " + b.boundsPoint+ "점입니다.");
    }

}

class Buyer{
    int money = 1000;
    int boundsPoint = 0;

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살수없음");
        }

        money -= p.price;
        boundsPoint += p.boundsPoint;
        System.out.println(p + "을/를 구입하셨습니다.");
    }
}

class Tv1 extends Product {
    Tv1() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Product {
    int price;
    int boundsPoint;

    Product(int price) {
        this.price = price;
        boundsPoint = (int) (price/10.0);
    }
}

