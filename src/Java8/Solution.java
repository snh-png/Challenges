package Java8;

import java.util.stream.Collectors;

class Solution {
    public boolean solution(String S, String T) {
//        char[] chars = T.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char digit = chars[i];
//            if(digit >= 0 && digit <= 9) {
//                char[] newPlacement = new char[digit];
//                String s = newPlacement.toString().replaceAll("/0", "?");
//            }
//        }
//
        String t = T.chars().mapToObj(i -> i >= 49 && i <= 57 ?
                new String(new char[Character.getNumericValue(i)]).replace('\0', '?') : "" + (char) i
        ).collect(Collectors.joining());

        String s = S.chars().mapToObj(i ->
            i >= 49 && i <= 57 ?
                new String(new char[Character.getNumericValue(i)]).replace('\0', '?') : "" + (char) i
        ).collect(Collectors.joining());

        if(s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char charAtS = s.charAt(i);
            char charAtT = t.charAt(i);

            if(charAtS != '?' && charAtT != '?' && charAtT != charAtS) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("A2Le", "2pL1"));
    }
}
