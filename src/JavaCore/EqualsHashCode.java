package JavaCore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCode {

    static class Employee {
        String name;
        int id;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && name.equals(employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Snehashish", 103);
        Employee emp2 = new Employee("Sneha", 105);
        Employee emp3 = new Employee("Sneha", 105);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);

        employeeSet.stream().forEach(System.out::println);
    }

}
