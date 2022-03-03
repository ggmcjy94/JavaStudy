package you.generics;

import java.util.ArrayList;

public class GenericsStudy {
    // 컴파일시 타입을 체크해 주는 기능
    // 객체의 타입 안정성을 높이고 형변환의 번거로움을 줄여줌

    //장점
    //1. 타입 안전성을 제공한다.
    //2. 타입체크와 형변환을 생략하 수 있으므로 코드가 간결해 진다. (class cast Exception 대처)
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>(); //좋은 코드
        list.add(10);
        list.add(20);
        list.add("30"); //String 추가

//        Integer i = (Integer) list.get(2); // 컴파일 OK
        // 실행할떄 에러
        //Integer i = list.get(2); //ArrayList<Integer> 이므로 캐스팅 안해도됌
        String i = (String) list.get(2);


        System.out.println("list = " + list);
    }
}
