package DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            TreeSet<Integer> A_input = new TreeSet<>();
            TreeSet<Integer> B_input = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                A_input.add(sc.nextInt());
            }
            n = A_input.size();
            for (int j = 0; j < m; j++) {
                B_input.add(sc.nextInt());
            }
            m = B_input.size();
            int x = sc.nextInt();
            Object[] A_objects = A_input.toArray();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = (Integer) A_objects[j];
            }

            Object[] B_objects = B_input.toArray();
            int[] b = new int[m];

            for (int j = 0; j < m; j++) {
                b[j] = (Integer) B_objects[j];
            }
/*
            mergeSort(a, n);
            mergeSort(b, m);*/

            if (result.length() > 0) result.append("\n");

            switch (x) {
                case 1:
                    result.append(andOperator(a, b));
                    break;
                case 2:
                    result.append(orOperator(a, b));
                    break;
                case 3:
                    result.append(xorOperator(a, b));
                    break;
                case 4:
                    result.append(inverseOperator(a, b));
                    break;
                case 5:
                    result.append(inverseOperator(b, a));
                    break;
            }
        }
        System.out.println(result.toString());

        System.exit(0);
    }

    private static String inverseOperator(int[] a, int[] b) {
        int i = 0, j = 0;
        StringBuilder result_Str = new StringBuilder("{");

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
                continue;
            } else if (a[i] < b[j]) {
                append(result_Str, a[i]);
                i++;
                continue;
            } else {
                j++;
                continue;
            }
        }

        while (i < a.length) {
            append(result_Str, a[i]);
            i++;
        }
        result_Str.append("}");
        return result_Str.toString();
    }

    private static void append(StringBuilder result_str, int i) {
        if (result_str.length() > 1)
            result_str.append(", ");
        result_str.append(i);
    }

    private static String xorOperator(int[] a, int[] b) {
        int i = 0, j = 0;
        StringBuilder result_Str = new StringBuilder("{");

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
                continue;
            } else if (a[i] > b[j]) {
                append(result_Str, b[j]);
                j++;
                continue;
            } else {
                append(result_Str, a[i]);
                i++;
                continue;
            }
        }

        while (i < a.length) {
            append(result_Str, a[i]);
            i++;
        }
        while (j < b.length) {
            append(result_Str, b[j]);
            j++;
        }
        result_Str.append("}");
        return result_Str.toString();
    }

    private static String orOperator(int[] a, int[] b) {
        int i = 0, j = 0;
        StringBuilder result_Str = new StringBuilder("{");

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                append(result_Str, a[i]);
                i++;
                continue;
            } else if (a[i] > b[j]) {
                append(result_Str, b[j]);
                j++;
                continue;
            } else {
                append(result_Str, a[i]);
                i++;
                j++;
                continue;
            }
        }

        while (i < a.length) {
            append(result_Str, a[i]);
            i++;
        }
        while (j < b.length) {
            append(result_Str, b[j]);
            j++;
        }
        result_Str.append("}");
        return result_Str.toString();
    }

    private static String andOperator(int[] a, int[] b) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        StringBuilder result_Str = new StringBuilder("{");

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                result.add(a[i]);
                append(result_Str, a[i]);
                i++;
                j++;
                continue;
            } else if (a[i] < b[j]) {
                i++;
                continue;
            } else {
                j++;
                continue;
            }
        }
        result_Str.append("}");
        return result_Str.toString();
    }

/*    public static void mergeSort(int[] a, int n) {
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

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else if (l[i] > r[j]) {
                a[k++] = r[j++];
            } else {
                a[k++] = l[i++];
                j++;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }*/
}
