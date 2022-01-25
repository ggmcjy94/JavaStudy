package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListStudy {


    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<>(10);

        list1.add(5);
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);

        ArrayList list2 = new ArrayList<>(list1.subList(1, 4));
        print(list1, list2);


        //Collection은 인터페이스 Collections는 유틸 클래스
        Collections.sort(list1); //정렬
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3,"A");
        print(list1,list2);

        list2.set(3, "AA");
        print(list1,list2);


        list1.add(0,"1");
        //indexOf는 지정된 객체의 위치(인덱스)를 알려준다.
        System.out.println("list1 = " + list1.indexOf("1"));
//        list1.remove(1); // 인덱스를 삭제
        list1.remove(Integer.valueOf(1)); // 값을 찾아서 삭제
        print(list1,list2);


        //list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
        print(list1,list2);

        //list2에서 list1에 포함된 객체들을 삭제한다. size 5 4 3 2 1
//        for (int i = 0; i < list.size(); i++) list.size = 5;
        // remove(0) = 1 2 3 4
        // remove(1) = 1 3 4
        // remove(2) = 1 3
        // remove(3) = 1 3 @@@ null 삭제
        // remove(4) = 1 3 @@@ null 삭제 배열복사 발생
        // 그래서 맨뒤에 부터 삭제해야 된다. 배열복사 발생 안함 뒤에서 부터 지워야 성능도 좋음
        for (int i = list2.size()-1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        print(list1,list2);
    }

    private static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println();
    }
}
