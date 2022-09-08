package Collection;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.HashMap;

    public class Key implements Comparable<Key> {

        // Custom input
        final int data = 118;
        private String key;

        // Constructor of this class
        public Key(String key)
        {
            // Super keyword refers immediate parent class
            // object
            super();

            // This keyword is a reference variable
            // referring to current object
            this.key = key;
        }

        // Print Key method
        public String printKey() { return this.key; }

        // Override compareTo method
        @Override public int compareTo(Key obj)
        {
            return key.compareTo(obj.key);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.key);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key1 = (Key) o;
            return key.equals(key1.key);
        }

        // Main driver method
        public static void main(String[] args)
        {
            // Initialize TreeMap
            // Declaring object of String type
            Map<Key, String> treemap = new TreeMap<>();

            // Adding the elements in object of TreeMap
            // Custom inputs
            treemap.put(new Key("Key1"), "Alice");
            treemap.put(new Key("Key4"), "Zeya");
            treemap.put(new Key("Key3"), null);
            treemap.put(new Key("Key2"), null);

            HashMap<Key, String> map = new HashMap<>();
            map.put(new Key("Key1"), "Alice");
            map.put(new Key("Key4"), "Zeya");
            map.put(new Key("Key3"), null);
            map.put(new Key("Key2"), null);
            map.put(new Key("Key2"), "Zeya");

            // Iterate over object elements using for-each loop
            for (Map.Entry<Key, String> entry :
                    treemap.entrySet())

                // Print elements in TreeMap object
                System.out.println(
                        "[" + entry.getKey().printKey() + " = "
                                + entry.getValue() + "]");
            System.out.println("**********");
            for (Map.Entry<Key, String> entry :
                    map.entrySet())

                // Print elements in TreeMap object
                System.out.println(
                        "[" + entry.getKey().printKey() + " = "
                                + entry.getValue() + "]");
        }
    }