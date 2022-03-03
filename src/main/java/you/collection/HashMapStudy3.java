package you.collection;

import java.util.*;

public class HashMapStudy3 {

    public static void main(String[] args) {
        String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};

        HashMap map = new HashMap();

        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i])) {
                int value = (int) map.get(data[i]);
                map.put(data[i], value +1);
            } else {
                map.put(data[i], 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int value = (int) entry.getValue();
            System.out.println(entry.getKey() + " : " +
                    printBar('#', value) + " " + value);
        }
    }

    private static Object printBar(char c, int value) {
        char[] bar = new char[value];
        Arrays.fill(bar, c);
        return new String(bar);
    }
}
