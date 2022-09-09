package Java8;

import java.util.function.Function;

public class MyFunction {

    public static void main(String[] args) {
        Function<String, String> replaceSlashes = dates -> dates.replace("-", "/");
        System.out.println(replaceSlashes.apply("Snehashish-Panigrahi"));
    }
}
