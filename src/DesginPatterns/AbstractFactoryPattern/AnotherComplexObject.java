package DesginPatterns.AbstractFactoryPattern;

public class AnotherComplexObject {
    private AnotherComplexObject(String name, int salary, String role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    private String name;
    private int salary;
    private String role;

    private static AnotherComplexObject getInstance(String name, int salary, String role) {
        return new AnotherComplexObject(name, salary, role);
    }
}