package Hashing;

//https://leetcode.com/problems/longest-happy-prefix/

//(a[i] p^i + a[i+1] p^(i+1) + a[i+2] p^(i+2))

//For prefixHash, if we simplify the above equation.
// ((a[i] * p) + a[i+1]) p
// h1 * 26 + first

public class LongestPrefixSuffix {
    public int longestPrefix(String s) {
        long h1 = 0, h2 = 0, mul = 1, len = 0, mod = 1000000000000000007l;
        for (int i = 0, j = s.length() - 1; j > 0; ++i, --j) {
            int first = s.charAt(i) - 'a', last = s.charAt(j) - 'a';
            h1 = (h1 * 26 + first) % mod;
            h2 = (h2 + mul * last) % mod;
            mul = mul * 26 % mod;
            System.out.println("Prefix h: " + h1 + ", Suffix h: " + h2);
            if (h1 == h2)
                len = i + 1;
        }
        return s.substring(0, (int) len).length();
    }

    public static void main(String[] args) {
        LongestPrefixSuffix longestPrefixSuffix = new LongestPrefixSuffix();
        System.out.println(longestPrefixSuffix.longestPrefix("abbabba"));
    }
}