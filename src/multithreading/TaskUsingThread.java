package multithreading;

public class TaskUsingThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //int i = 1/0;
        System.out.println("Thread -> I am running using: "+ Thread.currentThread());
    }

}

//1. create a class that extends Thread
//2. override run method
//3. write the logic in run method that needs to be executed
//4. create an object of the class that is EXTENDING Thread
//5. start the thread