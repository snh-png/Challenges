package Day_5;

public class SuperPalindrome {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int r = Integer.parseInt(String.valueOf(i) + reverse(i));
            int r1 = Integer.parseInt(String.valueOf(i) + reverseTrimmed(i));
            if (checkPalindrome(r * r)) System.out.println(r * r);
            if (checkPalindrome(r1 * r1)) System.out.println(r1 * r1);
        }
    }

    private static long reverseTrimmed(int i) {
        long reverse = reverse(i);
        if (reverse < 10) return reverse;
        return Integer.valueOf(String.valueOf(reverse).substring(1));
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