package DataStructure;

public class AllUniqueChar {
    public static void main(String[] args) {
        AllUniqueChar allUniqueChar = new AllUniqueChar();
        boolean isUniqueChars = allUniqueChar.isUniqueChars("abcz");
        System.out.println("is unique: " +isUniqueChars);
    }

    /*
    Basically, each number is represented in a position bit in bit_vector or checker.
    Example the array {1,3,5} would be represented as 0000 0000 0000 0000 0000 0000 0010 1010
    in a 32 bit integer

    1 << nums[i] shifts the number 1, nums[i] positions to the left

    The statement (bit_vector & (1 << nums[i])) > 0 indicates whether a number exist in the
    bit_vector already.

    For example: If we are checking to see if a number at position 5 exists we would use:
    (bit_vector & (1 << 5)) > 0

    The statement bit_vector |= (1 << nums[i]) is putting a number in the bit vector.
    For example if we want to flag a number at position 5, we would use:
    bit_vector |= (1 << 5)

*/
    
    boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println(1 << val);
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
