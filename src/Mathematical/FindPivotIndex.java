package Mathematical;

/*Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11*/


/*To understand the (prefixSum * 2) part, here's my way of conceptualizing it.
When nums[i] finds the actual pivot:
(sum - pivot) == sum(numbers to left of pivot) + sum(numbers to right of pivot).
In that case 'sum(numbers to left of pivot)' == 'sum(numbers to right of pivot)' or '2 * sum_of_right'
Thus '2 * sum_of_right' == sum - pivot, is true when nums[i] is the actual pivot, thus 'return i'.*/

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;

        int prefixSum = 0; // prefix sum to the left of index i
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int pivot = nums[i];
            if(prefixSum * 2 == sum - pivot) return i;
            prefixSum += pivot;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex sol = new FindPivotIndex();
        int [] arr = new int[]{2, 1, 2, 1};
        sol.pivotIndex(arr);
    }

}
