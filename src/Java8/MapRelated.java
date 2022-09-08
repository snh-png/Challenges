package Java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class MapRelated {
    public static void main(String[] s) {
//        Map<String, Boolean> whoLetDogsOut = new ConcurrentHashMap<>();
//        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
//        System.out.println(whoLetDogsOut.get("snoop"));
//        System.out.println(whoLetDogsOut.get("snosop"));

        // Create a HashMap and add some values
        HashMap<String, Integer> wordCount = new HashMap<>();
        wordCount.put("Geeks", 1);
        wordCount.put("for", 2);
        wordCount.put("geeks", 3);

        // print HashMap details
        System.out.println("Hashmap before operation :\n "
                + wordCount);

        // provide new value for keys which is present
        // using computeIfPresent method
        wordCount.computeIfPresent("for",
                new BiFunction<String, Integer, Integer>() {
                    @Override
                    public Integer apply(String key, Integer val) {
                        return val + 1;
                    }
                });

        // print new mapping
        System.out.println("HashMap after operation :\n "
                + wordCount);
    }
    /*static boolean f(String s) {
        System.out.println("creating a value for \""+s+'"');
        return s.isEmpty();
    }*/
}
