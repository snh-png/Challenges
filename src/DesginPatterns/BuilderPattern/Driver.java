package DesginPatterns.BuilderPattern;

public class Driver {

    public static void main(String[] args) {
        ComplexObjectBuilder builder = ComplexObject.getBuilder();
        ComplexObject build = builder.setName("sneh")
                .setRole("some_role")
                .setSalary(10000000)
                .build();


        //Another way
        ComplexObject complexObject = ComplexObject.Builder.newBuilder().setSalary(12121).build();
    }
}
