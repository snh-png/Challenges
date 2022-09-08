package DesginPatterns.AbstractFactoryPattern;

import DesginPatterns.BuilderPattern.ComplexObject;
import DesginPatterns.BuilderPattern.ComplexObjectBuilder;

public class Driver {

    public static void main(String[] args) {
        ComplexObjectBuilder builder = ComplexObject.getBuilder();
        ComplexObject build = builder.setName("sneh")
                .setRole("some_role")
                .setSalary(10000000)
                .build();
    }
}
