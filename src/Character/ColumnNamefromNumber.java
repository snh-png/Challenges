package Character;


//https://www.geeksforgeeks.org/find-excel-column-name-given-number/
public class ColumnNamefromNumber {
    static String colName (long n)
    {
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            sb.insert(0, (char)(n % 26 + 'A'));
            n = n / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(colName(703));
    }
}