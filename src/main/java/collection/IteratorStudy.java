package collection;

import java.util.*;
import java.util.stream.IntStream;

public class IteratorStudy {

    public static void main(String[] args) {
        Collection list = new ArrayList();
//        Collection c1 = new HashSet();
//        Collection c2 = new TreeSet();


        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        Iterator iterator = list.iterator(); //1회용
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }


        Map map = new HashMap();
        Iterator iterator1 = map.entrySet().iterator();
        Iterator iterator2 = map.keySet().iterator();
        Iterator iterator3 = map.values().iterator();


    }
}
