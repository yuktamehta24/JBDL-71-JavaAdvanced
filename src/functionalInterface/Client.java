package functionalInterface;

public class Client {

    public static void main(String[] args) {
        Calculator calculator = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };

        Calculator calculator1 = (a, b) -> a+b;
        Calculator calculator2 = (int a, int b) -> a+b;
        Calculator calculator3 = (a, b) -> {
            System.out.println("In add function");
            return a+b;
        };

        System.out.println(calculator.add(3, 7));
        System.out.println(calculator1.add(3, 7));
        System.out.println(calculator2.add(3, 7));
        System.out.println(calculator3.add(3, 7));
        System.out.println(calculator.multiply(3, 7));
        System.out.println(calculator1.multiply(3, 7));
        System.out.println(calculator2.multiply(3, 7));
        System.out.println(calculator3.multiply(3, 7));

    }
}
