package you.generics;

import java.util.HashMap;

public class GenericsHashMapStudy {

    public static void main(String[] args) {
        HashMap<String,Student1> map = new HashMap<>();
        map.put("자바왕", new Student1("자바왕",1,1,100,100,100));

        Student1 s = map.get("자바왕");
        System.out.println("s = " + s.name);

        System.out.println("map = " + map);
    }
}

class Student1 {
    String name="";
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student1(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
