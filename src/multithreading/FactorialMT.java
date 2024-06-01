package multithreading;

import java.math.BigInteger;

public class FactorialMT implements Runnable {

    private int num;

    FactorialMT(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        BigInteger fac = BigInteger.ONE;
        for (int i=1; i<= num; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Current thread for "+ num + " is " +Thread.currentThread().getName());
        System.out.println("factorial of " + num + " is " + fac);
    }
}
