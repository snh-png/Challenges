package DataStructure.Trie;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String keys[] = {"their", "apple"};
        Trie t = new Trie();
        System.out.println("Keys to insert: " + Arrays.toString(keys));
        IntStream.range(0, keys.length).forEach(
                i -> {
                    t.insert(keys[i]);
                    System.out.println("\"" + keys[i] + "\" inserted");
                }
        );

        System.out.println(t.search("apple"));
        System.out.println(t.search("ample"));
        System.out.println(t.search("the"));
    }
}
