package DataStructure;

public class SuperPalindrome {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            int r_odd = oddR(i);
            int r_even = evenR(i);
            if (checkPalindrome(r_odd * r_odd)) System.out.println(r_odd * r_odd);
            if (checkPalindrome(r_even * r_even)) System.out.println(r_even * r_even);
        }
    }

    private static int oddR(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int length = sb.length();
        for (int i = length - 2; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    private static int evenR(int n) {
        StringBuilder sb = new StringBuilder(n);
        sb.append(n);
        int length = sb.length();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    private static boolean checkPalindrome(int i) {
        if (reverse(i) == i) return true;
        return false;
    }

    public static long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
    }
}