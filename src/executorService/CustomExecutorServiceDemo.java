package executorService;

import multithreading.TaskUsingRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException {
        //corepool size -> 4
        //maxpolsize -> 10
        //Arrayblockingqueue -> 3

        ExecutorService ex1 = new ThreadPoolExecutor(
                4, 10, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3)
        );

        TaskUsingRunnable taskUsingRunnable = new TaskUsingRunnable(); //runnable

        for (int i =0; i<30; i++) {
            try {
                ex1.submit(taskUsingRunnable); //main
            } catch (Exception e) {
                System.out.println("Exception is: "+ e);
            }

        }

        ex1.shutdown();
        ex1.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("I am in main using thread: "+ Thread.currentThread().getName());
    }
}
