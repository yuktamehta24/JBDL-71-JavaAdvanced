package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientFactorial {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> input1 = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000 ,7000 ,8000 ,9000 ,10000);

        long start = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

//        for (int i =0 ; i< 10; i++) {
//            FactorialMT mt = new FactorialMT(input1.get(i));
//            Thread thread = new Thread(mt);
//            thread.start();
//            thread.join();
//        }


        input1.stream().forEach(num -> {
            System.out.println("Current thread is: "+ Thread.currentThread());
            FactorialMT mt = new FactorialMT(num);
            Thread thread = new Thread(mt);
            thread.start(); //non blocking
            threads.add(thread);
//            try {
//                thread.join(); //1000 2000
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        });

        threads.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //join()
        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+ (end-start));

    }

}
