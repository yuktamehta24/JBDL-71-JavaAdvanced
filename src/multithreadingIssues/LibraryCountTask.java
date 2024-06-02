package multithreadingIssues;

import java.util.concurrent.atomic.AtomicInteger;

public class LibraryCountTask implements Runnable {

//    private int count;
    private AtomicInteger count;

    private Object lock = new Object();

    public LibraryCountTask() {
//        count = 0;
        count = new AtomicInteger(0);
    }

    public int getCount() {
        return count.get();
    }

    @Override
    public void run() {
        incrementCount2();
    }

    //performance issues
    private synchronized void incrementCount() {
//        count++;
    }

    private void incrementCount2() {
        count.addAndGet(1);
    }

    private void incrementCount1() {
        //
        //
        //
        //
        synchronized (lock) {
            //count++;
        }
        //
        //
        //
        //
    }
}
