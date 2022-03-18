package you.oop;

public interface interfaceStudy {
    void move(int x , int y) ;
    void attack(interfaceStudy itf); // interface 를 구현한 클래스의 인스턴스만 가능
    //충돌 날떄 오버라이딩 하면 됌
    default void attack2(interfaceStudy itf){};
}
