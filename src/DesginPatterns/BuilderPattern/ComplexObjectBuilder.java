package DesginPatterns.BuilderPattern;

//Builder Pattern creates an immutable object
public class ComplexObjectBuilder {
    private String name;
    private int salary;
    private String role;

    public ComplexObjectBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ComplexObjectBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public ComplexObjectBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    public ComplexObject build() {
        return new ComplexObject(name, salary, role);
    }

}