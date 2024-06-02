package executorService;

import multithreading.TaskUsingRunnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService ex1 = Executors.newFixedThreadPool(4);
        ExecutorService ex2 = Executors.newSingleThreadExecutor();

        ExecutorService ex3 = Executors.newCachedThreadPool();

        ScheduledExecutorService ex4 = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService ex5 = Executors.newSingleThreadScheduledExecutor();

        TaskUsingRunnable taskUsingRunnable = new TaskUsingRunnable(); //runnable


        ex4.submit(taskUsingRunnable);
        ex4.schedule(taskUsingRunnable, 1, TimeUnit.SECONDS);


//
//        Runnable task2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("This is my task 2 using thread: "+ Thread.currentThread().getName());
//            }
//        };
//
//        for(int i = 0; i< 20; i++) {
//            ex3.submit(taskUsingRunnable);
//        }
//        ex3.submit(task2);
//

        ex1.shutdown();
        ex2.shutdown();
        ex3.shutdown();
        ex4.shutdown();
        ex5.shutdown();

//        ex4.shutdownNow();

//        ex5.submit(taskUsingRunnable);

        ex4.awaitTermination(4000, TimeUnit.MILLISECONDS); //join(timeout)
//        ex4.close(); //join()
        // COMPLETES IN 3 SECONDS, MAIN WOULD START AFTER 3 SECONDS
        // COMPLETES IN 6 SECONDS, MAIN WOULD START AFTER 4 SECONDS

        System.out.println("I am in main using thread: "+ Thread.currentThread().getName());

        Thread.sleep(1000);

        System.out.println("After sleep I am in main using thread: "+ Thread.currentThread().getName());

        ExecutorService ex10 = Executors.newFixedThreadPool(4);
        CallableTask ct = new CallableTask();
        TaskUsingRunnable rt = new TaskUsingRunnable();

        Future<String> res1 = ex10.submit(ct); //is this is a blocking call
        ex10.submit(rt);
        ex10.shutdown();

//        String res3 = res1.get();
        String res = res1.get(4000, TimeUnit.MILLISECONDS); //blocking call
        System.out.println("RES IS: "+ res);
        System.out.println("I am in main thread");

    }
}
