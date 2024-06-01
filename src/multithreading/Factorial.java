package multithreading;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Factorial {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10);
        List<Integer> input1 = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000 ,7000 ,8000 ,9000 ,10000);

        long start = System.currentTimeMillis();
        input1.stream().parallel().forEach(num -> {
            BigInteger res = factorial(num);
            System.out.println("Current thread for "+ num + " is " +Thread.currentThread().getName());
            System.out.println("factorial of " + num + " is " + res);
        });

        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+ (end-start));
    }

    public static BigInteger factorial(int num) {
        BigInteger fac = BigInteger.ONE;
        for (int i=1; i<= num; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }
}
