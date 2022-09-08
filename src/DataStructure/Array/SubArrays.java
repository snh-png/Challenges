package DataStructure.Array;

public class SubArrays {
    public static void main(String[] args) {
        int[] arr = new int[] {-1, -2, 3, -4};
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            String res = "";
            for (int j = i; j < arr.length; j++) {
//                res += arr[j] + " ";
//                System.out.println(res);
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                ans = Math.max(ans, sum);
                System.out.println();
            }
        }
        System.out.println("***" + ans + "***");
    }
}
