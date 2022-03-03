package you.generics;


import java.util.ArrayList;

class Fruit implements Eatable{
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit {
    @Override
    public String toString() {
        return "Grape";
    }
}
class Toy {
    public String toString() {
        return "Toy";
    }
}

interface Eatable{}


public class ExtendsGenericsStudy {

    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();
//        FruitBox<Grape> grapeBox = new FruitBox<Apple>(); //에러 타입 불일치
//        FruitBox<Toy> toyBox = new FruitBox<>(); //에러 자손이 아님

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//        appleBox.add(new Grape()); // 에러 grape 는 apple 의 자손이 아님
        grapeBox.add(new Grape());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("grapeBox = " + grapeBox);
        System.out.println("appleBox = " + appleBox);

    }
}

class FruitBox<T extends  Fruit & Eatable> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);
    }
    T get(int i) {
        return list.get(i);
    }
    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

// static 멤버에 타입 변수 사용 불가

// 배열 생성할 때 타입 변수 사용불가 타입 변수로 배열 선언은 가능