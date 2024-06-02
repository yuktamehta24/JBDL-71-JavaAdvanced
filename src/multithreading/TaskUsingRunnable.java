package multithreading;

public class TaskUsingRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Runnable I am running using: "+ Thread.currentThread().getName());
    }
}


//1. create a class that implements runnable
//2. implement run method
//3. write the logic in run method that needs to be executed
//4. create an object of the class that is implementing runnable
//5. create an object of thread class,and supply runnable instance
//6. start the thread

