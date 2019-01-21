package Day_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SG {
    public static void main(String[] args) {

        List<String> output = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        if (test_cases > 10000 || test_cases < 1) throw new IllegalArgumentException();
        sc.skip("[\\r\\n]+");
        for (int n = 0; n < test_cases; n++) {
            String chromosome = sc.nextLine();
            chromosome = chromosome.replace(" ", "");
            if (chromosome.trim().length() >= 100 || chromosome.trim().length() < 1)
                throw new IllegalArgumentException();
            String gene = sc.nextLine();
            gene = gene.replace(" ", "");
            if (gene.length() >= chromosome.length() || gene.length() < 1) throw new IllegalArgumentException();

            //find gene in chromo
            int i = 0;
            int genes_match_count = 0;
            for (Character ch_Gene : gene.toCharArray()) {
                for (; i < chromosome.length(); i++) {
                    if (ch_Gene.equals(chromosome.charAt(i))) {
                        genes_match_count++;
                        break;
                    }
                }
            }
            if (genes_match_count == gene.length()) output.add("YES");
            else output.add("NO");
        }

        for (String op : output)
            System.out.println(op);

        System.exit(0);
    }
}
