package DataStructure;

import java.util.stream.IntStream;

class StringRoller {
    public static void main(String[] args) {
        String s = "zcza";
        int k[] = {1, 1, 3, 4};
        System.out.println(roll(s, k));
    }

    public static String roll(String toRoll, int roll[]) {

        int toRollLength = toRoll.length();
        int each_character_roll[] = new int[toRollLength];
        char[] toRollCharArr = toRoll.toCharArray();

        for (int i = 0; i < roll.length; ++i) {
            ++each_character_roll[0];
            int noOfRoll = roll[i];
            if (noOfRoll >= each_character_roll.length)
                continue;
            else
                --each_character_roll[noOfRoll];
        }

        IntStream.range(1, toRollLength).forEach(index -> {
            each_character_roll[index] = each_character_roll[index] + each_character_roll[index - 1];
        });

        IntStream.range(0, toRollLength).forEach(index -> {
            toRollCharArr[index] = roll_character(toRollCharArr[index], each_character_roll[index]);
        });

        return String.valueOf(toRollCharArr);

    }

    public static char roll_character(char c, int roll) {
        roll = roll % 26;
        int character = c - 'a';

        return (char) ('a' + (character + roll) % 26);
    }
}