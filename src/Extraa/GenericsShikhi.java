package Extraa;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsShikhi {
    public static void main(String[] args) {
        Integer i = 55;
        ArrayList<Integer> li = new ArrayList<>();
        li.add(i);
        System.out.println(shout(li));

    }
    // to declare generic for ArrayList
    static ArrayList<?> shout(ArrayList<?> sht){

        return sht;
    }
}
