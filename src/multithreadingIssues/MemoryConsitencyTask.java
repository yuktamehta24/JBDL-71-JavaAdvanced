package multithreadingIssues;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryConsitencyTask implements Runnable {

//    private static volatile int data = 0;
    private static AtomicInteger data = new AtomicInteger(0);

    private String type;

    MemoryConsitencyTask(String type) {
        this.type = type;
    }


    //"W" -> increment data till 5
    //"R" -> read the data whenever it is incremented
    @Override
    public void run() {
        if ("W".equals(type)) {
            while (data.get() != 5) {
//                data++; //1
                data.addAndGet(1);
                System.out.println("Updated the data value to "+ data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else { //"R"
            int temp = 0;
            while(true) { //infinite loop
                if (temp != data.get()) {
                    temp = data.get(); //1
                    System.out.println("I have read the new data as "+ temp);
                }
            }

        }
    }
}
