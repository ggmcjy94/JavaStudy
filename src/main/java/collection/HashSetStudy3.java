package collection;

import java.util.*;

public class HashSetStudy3 {

    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("abc");
        set.add("abc");

        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println("set = " + set);
    }
}


//equals 와 hashCode 를 오버라이딩 해야 hashSet 이 바르게 동작
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
