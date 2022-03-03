package you.collection;

import java.util.*;

import static java.util.Collections.*;

public class CollectionsStaticStudy {

    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println("list = " + list);

        addAll(list, 1,2,3,4,5);
        System.out.println("list = " + list);

        rotate(list, 2); // 반시계 방향으로 2칸이동 (오른쪽)
        System.out.println("list = " + list);


        swap(list, 0,2); // 첫번째 와 세번째를 교환
        System.out.println("list = " + list);

        shuffle(list); // 저장된 요소의 위치를 임의로 변경
        System.out.println("list = " + list);

        sort(list, reverseOrder()); //역순 정렬 reverse(list) 와 동일
        System.out.println("list = " + list);

        sort(list); // 정렬
        System.out.println("list = " + list);

        int idx = binarySearch(list, 3);
        System.out.println("idx of 3 = " + idx);

        System.out.println("max(list) = " + max(list));

        System.out.println("min(list) = " + min(list));

        System.out.println("min = max(list, reverseOrder()) = " + max(list, reverseOrder())); //min

        fill(list, 9); //리스트를 9로 채운다
        System.out.println("list = " + list);

        // list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단 결과는 변경불가
        List newList = nCopies(list.size(), 2);

        System.out.println("disjoint(list, newList) = " + disjoint(list, newList));

        copy(list, newList);
        System.out.println("newList = " + newList);
        System.out.println("list = " + list);

        replaceAll(list, 2, 1);
        System.out.println("list = " + list);

        Enumeration e = enumeration(list); //iterator 와 비슷
        ArrayList list2 = list(e);

        System.out.println("list2 = " + list2);



    }
}
