package generics;

import java.util.ArrayList;
import java.util.List;

class Product{}
class Tv extends Product{}
class Audio extends Product{}

public class GenericsStudy3 {

    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv> tvList = new ArrayList<Tv>();
        //ArrayList<Product> tvList = new ArrayList<Tv>(); 에러
        // List<Tv> tvList = new ArrayList<Tv>(); 다형성 OK

        productList.add(new Tv());
        productList.add(new Audio());

        tvList.add(new Tv());
        tvList.add(new Tv());

        printAll(productList);
//        printAll(tvList); //에러
    }

    private static void printAll(ArrayList<Product> productList) {
        for (Product product : productList) {
            System.out.println("product = " + product);
        }
    }
}
