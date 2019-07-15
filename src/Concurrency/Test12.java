package Concurrency;

import java.util.ArrayList;
import java.util.List;

public class Test12 {
    public static void main(String[] args) {

        Test12 ibj = new Test12();
        ibj.display();
    }

    public void display() {
        List<Object> list = new ArrayList<>();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        System.out.println(list);
        for (Object str : list) {
            str = new Object();

        }
        System.out.println(list);
    }
}
