package Concurrency;

import java.util.Iterator;
import java.util.TreeMap;

public class Test14 {
    public static void main(String[] args) {
        Test14 hacks = new Test14();
        hacks.hackMap();
    }

    private void hackMap() {
        TreeMap he = new TreeMap();
        he.put("x", "Hacker");
        he.put("y", "Earth");
        he.put("z", "ackathos");
        Iterator it = he.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
