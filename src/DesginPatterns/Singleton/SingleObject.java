package DesginPatterns.Singleton;

public class SingleObject {
    private static SingleObject singleObject = new SingleObject();
    private static int test = 34325;
    private int ds = 231231;

    private SingleObject() {}

    public static SingleObject getInstance() {
        return singleObject;
    }

    public static void main(String[] args) {
        SingleObject.getInstance();
    }
}
