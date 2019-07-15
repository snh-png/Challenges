package Concurrency;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();
        names.put("A", 10);
        names.put("J", 35);
        names.put("B", 2);
        Set<Map.Entry<String, Integer>> set = names.entrySet();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(" " + entry.getKey());
        }
    }
}
