package JavaCore.FileSamples;

import java.util.HashMap;
import java.util.Map;

public class StarterCodse {
    public static String getAddress(Map map, Employee emp) {
        Address adrs = (Address) map.get(emp);
        return adrs.getAddress();
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(111, "Alice", "Singh");
        Address adrs1 = new Address(203, "Seepz", "Mumbai", 400093);

        Employee emp2 = new Employee(110, "Bob", "Singh");
        Address adrs2 = new Address(304, "Marol", "Mumbai", 400069);

        Map<Employee, Address> map = new HashMap<>();
        map.put(emp1, adrs1);
        map.put(emp2, adrs2);

        System.out.println(StarterCodse.getAddress(map, new Employee(110, "Alice", "Kapoor")));
    }
}
