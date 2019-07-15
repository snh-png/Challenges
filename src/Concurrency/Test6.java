package Concurrency;

import java.util.ArrayList;
import java.util.Iterator;

public class Test6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        list.add(6);
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
//        String[] test = {"test", "fuck"};
//        Arrays.sort(test, (o1, o2) -> o1.compareTo(o2));
    }
}
