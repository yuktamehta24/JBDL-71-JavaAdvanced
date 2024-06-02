package multithreadingIssues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(4);

        LibraryCountTask task = new LibraryCountTask();

        for(int i=0; i<200000; i++) {
            ex.submit(task);
        }

        ex.shutdown();
        ex.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("Total no. of people in the library" +
                " are: "+ task.getCount());

        ExecutorService ex1 = Executors.newFixedThreadPool(2);
        MemoryConsitencyTask write = new MemoryConsitencyTask("W");
        MemoryConsitencyTask read = new MemoryConsitencyTask("R");

        ex1.submit(write);
        ex1.submit(read);

        ex1.shutdown();
        ex1.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("In main thread");

    }
}
