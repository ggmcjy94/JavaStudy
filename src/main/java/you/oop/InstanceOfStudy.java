package you.oop;

public class InstanceOfStudy {

    public static void main(String[] args) {
        FireEngine fe = new FireEngine();
        System.out.println(fe instanceof Object);
        System.out.println(fe instanceof Car);
        System.out.println(fe instanceof FireEngine);
    }

    void doWork(Car c) {
        if (c instanceof FireEngine) { //1.형변환 가능한지 확인
            FireEngine fe = (FireEngine) c;//2.형변환
            fe.water();
        }
    }

}

class Car {
}

class FireEngine extends Car{
    void water(){

    }
}
