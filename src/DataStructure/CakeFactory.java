package DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class CakeFactory {
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static boolean findSum(int[] a, int sum) {
        int i = 0, tempSum = 0, j = a.length - 1;
        if (i == j && a[i] == sum) return true;
        while (i < j) {
            if (a[i] + a[j] == sum || a[i] == sum || a[j] == sum) return true;
            else if (a[i] + a[j] > sum) j--;
            else {
                if (tempSum + a[i] == sum) return true;
                else if (tempSum + a[i] > sum) {
                    tempSum = 0;
                } else {
                    if (tempSum > 0)
                        tempSum = tempSum + a[i];
                    else
                        tempSum = tempSum + a[i] + a[j];
                }
                i++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int a[] = new int[sc.nextInt()];
            int i = 0;
            while (sc.hasNextInt() && i < a.length)
                a[i++] = sc.nextInt();
            int sum = sc.nextInt();

            mergeSort(a, a.length);
            System.out.println("Sorted: " + Arrays.toString(a));
            System.out.println(findSum(a, sum) == true ? "YES" : "NO");
        }
    }
}
