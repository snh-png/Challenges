package DataStructure.Array;

// Returns minimum number of platforms reqquired

import java.util.Arrays;

public class MinPlat {
    public static void main(String[] args) {
        int arr[] = {900,940,950,1100,1500,1800};
        int dep[] = {910,1200,2000,1130,1900,2000};
        int n = arr.length;
        System.out.println(findPlatform(arr, dep, n));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n)
        {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j])
            {
                plat_needed++;
                i++;

                // Update result if needed
                if (plat_needed > result)
                    result = plat_needed;
            }

            // Else decrement count of platforms needed
            else
            {
                plat_needed--;
                j++;
            }
        }
        return result;
    }
}
