package DesginPatterns.BuilderPattern;

public class ComplexObject {
    public ComplexObject(String name, int salary, String role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public ComplexObject() {
    }

    public static ComplexObjectBuilder getBuilder() {
        return new ComplexObjectBuilder();
    }

    private String name;
    private int salary;
    private String role;


    public static class Builder {
        private final ComplexObject complexObject = new ComplexObject();

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setSalary(int salary) {
            this.complexObject.salary = salary;
            return this;
        }

        public ComplexObject build() {
            return this.complexObject;
        }
    }
}