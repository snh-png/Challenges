package Java8;

import java.util.*;

public class Test1 {
    static class Element {
        public int getDecimal() {
            return decimal;
        }

        public String getBinary() {
            return binary;
        }

        int decimal;
        String binary;

        public Element(int decimal, String binary) {
            this.decimal = decimal;
            this.binary = binary;
        }
    }


    public static void main(String[] args) {
        Integer[] input = new Integer[] { 7, 8, 6, 5};
        List<Element> elements = new ArrayList<>();
        for (Integer element: Arrays.asList(input)) {
            String binaryElement = Integer.toBinaryString(element);
            Element newEl = new Element(element, binaryElement);
            elements.add(newEl);
        }
        Comparator<String> onesCountComparator = Comparator.comparing(c -> countOfOnes(c));
        Collections
                .sort(
                        elements,
                        Comparator
                                .comparing(Element::getBinary, onesCountComparator)
                                .thenComparingInt(Element::getDecimal));
//        elements.stream().sorted(onesCountComparator.thenComparingInt(Element::getDecimal));
        elements.forEach(el -> System.out.println(el.getDecimal()));
    }

    public static long countOfOnes(String element) {
       return element.chars().filter(c -> c == '1').count();
    }


}
