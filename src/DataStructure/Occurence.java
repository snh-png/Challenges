package DataStructure;

public class Occurence {

    private static int mainCounter;

    public static void main(String[] args) {
        String str = "xyz is a good place a to work";
        String subStr = " a ";
        char[] inputString_Chars = str.toCharArray();
        char[] inputSubString_Chars = subStr.toCharArray();
        int matchingCharCount = 0;
        int j = 0;
        int i = 0;
        for (; i < inputString_Chars.length; i++) {
            while (j < inputSubString_Chars.length) {
                if (inputSubString_Chars[j] == inputString_Chars[i]) {
                    matchingCharCount++;
                    j++;
                } else {
                    matchingCharCount = 0;
                    j = 0;
                }
                break;
            }
            if (matchingCharCount == subStr.length()) {
                mainCounter++;
                matchingCharCount = 0;
                j = 0;
            }
        }
        System.out.println("matchingCharCount: " + mainCounter);
    }
}
