package you.oop;

public class Fighter implements interfaceStudy{
    @Override
    public void move(int x, int y) {

    }

    @Override
    public void attack(interfaceStudy itf) {

    }


    public static void main(String[] args) {
        interfaceStudy f = new Fighter();
        f.attack(new Fighter());
    }
}
