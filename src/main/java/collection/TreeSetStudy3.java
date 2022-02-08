package collection;


import java.util.TreeSet;

public class TreeSetStudy3 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set.add(score[i]);
        }

        System.out.println("50보다 작은 값 = " + set.headSet(50));
        System.out.println("50보다 같거나 큰 값 = " + set.tailSet(50));
        System.out.println("40 ~ 80  = " + set.subSet(40,80) );
    }

}
