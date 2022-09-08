package LinkedinAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Solution {
    /*public static void main(String[] args) {
        String[] array = {"A", "B", "C"};
        List<String> list1 = Arrays.asList(array);
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(array));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));

        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
    }*/

    public static void main(String[] args) {
        double pi = 2;
        int jar = (int)pi;
        Solution sol = new Solution();

//        Function<String, String> cap = str -> str.toUpperCase();
        Function<Integer, Integer> cap = x -> x*x;

        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

        Function<String, String> replaceSlashes = dates -> dates.replace("-", "/");

        for (String value : list) {
            if(value.equals("a")) list.remove(value);
        }
    }

    public int square(int x) {
        return x*x;
    }



}
