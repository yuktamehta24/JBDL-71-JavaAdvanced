package multithreading;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        //using runnable
        TaskUsingRunnable taskUsingRunnable = new TaskUsingRunnable();

        Thread thread = new Thread(taskUsingRunnable);
//        thread.setPriority(10);
        thread.start();
//
//        Thread thread1 = new Thread();
//        thread1.start();

        // using Thread
        Thread taskUsingThread = new TaskUsingThread();
//        taskUsingThread.setPriority(1);
        taskUsingThread.setDaemon(true);
        taskUsingThread.start();

        Thread.sleep(5000);
        System.out.println("I am in main method with thread: "+ Thread.currentThread());



    }
}
