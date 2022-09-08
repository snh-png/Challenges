package DP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNonAdjacentSum {
    /*public static int maxNonAdjSum(int[] arr, int i, int sum) {
        if(i >= arr.length) return arr[i];
        int include = maxNonAdjSum(arr, i+2, sum+arr[i]);
        int exclude = maxNonAdjSum(arr, i+1, sum);

        return Math.max(include, exclude);
    }*/

//  Memoizaiton Solution
    public static int maxNonAdjSumWithMemoization(int[] arr, int i, int[] maxCache) {
        if(i >= arr.length) return 0;
        if(maxCache[i] != -1) return maxCache[i];
        int include = maxNonAdjSumWithMemoization(arr, i+2, maxCache) + arr[i];
        int exclude = maxNonAdjSumWithMemoization(arr, i+1, maxCache);
        maxCache[i] = Math.max(include, exclude);
        return maxCache[i];
    }

    /*public static int maxNonAdjSum(int[] arr, int i) {
        if(i >= arr.length) return 0;
        int include = maxNonAdjSum(arr, i+2) + arr[i];
        int exclude = maxNonAdjSum(arr, i+1);
        return Math.max(include, exclude);
    }*/

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();

        int[] arr = new int[] {9, 9, 8, 2};//17
//        int[] arr = new int[] {1, 2, 4};//5
//        int[] arr = new int[] {2, 1, 4, 9};//11
//        System.out.println(maxNonAdjSum(arr, 0, 0));

//         Memoizaiton Solution
        /*int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maxNonAdjSumWithMemoization(arr, 0, dp));*/
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(funcT(Arrays.stream(arr).boxed().toList(), arr.length-1, dp));
    }

    private static int funcT(List<Integer> nums, int last, int arr[]){

        arr[0] = nums.get(0);

        for(int i=1; i<=last;i++){
            int pick = nums.get(i);
            if(i>1) pick += arr[i-2];//if you are picking up i th elm, then i-2th elm of "cumulative sum" arr can also be added.

            int noPick = arr[i-1];//if you are not picking up i th elm, then add i-1th elm

            arr[i] = Math.max(pick, noPick);
        }

        return arr[last];
    }
}
