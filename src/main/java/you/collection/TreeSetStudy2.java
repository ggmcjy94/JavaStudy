package you.collection;


import java.util.TreeSet;

public class TreeSetStudy2 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc"); set.add("alien"); set.add("bat");
        set.add("car"); set.add("Car"); set.add("disc");
        set.add("dance"); set.add("dzzzz"); set.add("dzzzz");
        set.add("elephant"); set.add("elevator"); set.add("fan");
        set.add("flower");

        System.out.println("set = " + set);
        System.out.println("from = " + from +" to = "+to);
        System.out.println("set.subSet(from, to) = " + set.subSet(from, to));
        System.out.println("set.subSet(from, to+\"zzz\") = " + set.subSet(from, to+"zzz"));
    }

}
