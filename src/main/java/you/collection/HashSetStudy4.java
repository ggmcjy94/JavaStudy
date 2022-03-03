package you.collection;

import java.util.*;

public class HashSetStudy4 {

    public static void main(String[] args) {
        HashSet setA = new HashSet(); // 순서 x 중복 x set 의 특징
        HashSet setB = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1"); setA.add("2"); setA.add("3");
        setA.add("4"); setA.add("5");
        System.out.println("setA = " + setA);

        setB.add("4"); setB.add("5"); setB.add("6");
        setB.add("7"); setB.add("8");
        System.out.println("setB = " + setB);

        
        
        //교집함 
//        setA.retainAll(setB);
//        System.out.println("setA = " + setA);

        //합집합
//        setA.addAll(setB);
//        System.out.println("setA = " + setA);

        //차집함
//        setA.removeAll(setB);
//        System.out.println("setA = " + setA);
        
        
        for (Object b : setB) {
            if (setA.contains(b)) {
                setKyo.add(b);
            }
        }

        for (Object a : setA) {
            if (!setB.contains(a)) {
                setCha.add(a);
            }
        }

        for (Object a : setA) {
            setHab.add(a);
        }

        for (Object b : setB) {
            setHab.add(b);
        }

        System.out.println("A kyo B = " + setKyo);
        System.out.println("A Hab B = " + setHab);
        System.out.println("A - B = " + setCha);

    }
    
}
