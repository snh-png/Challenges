import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int numArr[] = {-9, -5, -3, 1, 2, 3};
        List<String> output = new ArrayList<>();
        int sum;

        for (int i = 0; i < numArr.length - 2; i++) {
            sum = -numArr[i];
            int lowIndex = i + 1;
            int highIndex = numArr.length - 1;
            if (numArr[i] > 0) break;
            int twoSum = numArr[lowIndex] + numArr[highIndex];
            while (twoSum < sum) {
                if (lowIndex + 1 < highIndex) {
                    lowIndex++;
                    twoSum = numArr[lowIndex] + numArr[highIndex];
                } else break;
            }
            while (twoSum > sum) {
                if (highIndex - 1 > lowIndex) {
                    highIndex--;
                    twoSum = numArr[lowIndex] + numArr[highIndex];
                } else break;
            }
            if (twoSum == sum)
                output.add(numArr[i] + ", " + numArr[lowIndex] + ", " + numArr[highIndex]);
        }
        System.out.println("output: " + output);
    }
}
