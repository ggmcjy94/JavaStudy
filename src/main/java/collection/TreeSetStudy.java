package collection;
//이진 탐색 트리 (바이너리 서치 트리) 로 구현 범위 탐색과 정렬에 유리
//이진 트리는 모든 노드가 최대 2개의 하위 노드를 갖음

// 이진 탐색트리
// Tree Set은 이진 탐색트리로 되어있음
// 부모보다 작은 값은 왼쪽 큰 값은 오른쪽에 저장
// 단점 데이터가 많아질 수록 추가 삭제에 시간이 더걸림(비교횟수 증가)


// 7, 4, 9, 1, 5
// 7 저장 -> 4 비교 (왼쪽) -> 9비교 (오른쪽) -> 7 > 1 , 4 비교 (왼쪽)
// 7 > 5 , 4 비교 (오른쪽)

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *          7
 *       4     9
 *     1   5
 **/
public class TreeSetStudy {

    public static void main(String[] args) {
        Set set = new TreeSet(); //정렬

        for (int i =0; set.size() < 6; i++) {
            int num = (int) ((Math.random()*45) +1);
            set.add(num);
        }

//        set.add(new Test());
//        set.add(new Test());
//        set.add(new Test());
//        set.add(new Test());
//        set.add(new Test());
        System.out.println("set = " + set);
    }

}

////tree set 은 비교 기준이 필요해 Comparable,Comparator 을 해야된다 왜냐 정렬을 해야되므로
//class Test implements Comparable{
//
//    @Override
//    public int compareTo(Object o) {
//        return -1;
//    }
//}
//
//
//class TestComp implements Comparator {
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        return 1;
//    }
//}
