package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetStudy {

    public static void main(String[] args) {
        Object[] objArr = {"1", Integer.valueOf(1), "2","2","3","3","4","4","4"};
        Set set = new HashSet();

        for (int i = 0; i <objArr.length; i++) {
            set.add(objArr[i]);
        }

        System.out.println("set = " + set); //중복 된것들은 다빠져있다. 1은 String integer 다른 객체이므로

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println("it.next() = " + it.next());
        }
    }
    
}
