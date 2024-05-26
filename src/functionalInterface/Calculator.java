package functionalInterface;

@FunctionalInterface
public interface Calculator {
    int add(int a, int b);

    default int add(int a, int b, int c) {
        return 0;
    }

    default int multiply(int a, int b) {
        return a*b;
    }

    default int divide(int a, int b) {
        return a/b;
    }

}
