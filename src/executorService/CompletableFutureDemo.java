package executorService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<Void> cf = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am in run async");
            }
        });


        CompletableFuture<Void> cf1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("supply async thread: " +Thread.currentThread().getName());
                System.out.println("I am in supplyasync");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                return "I am in supply async";
            }
        }, executorService)
                .exceptionally(new Function<Throwable, String>() {
                    @Override
                    public String apply(Throwable throwable) {
                        return "";
                    }
                }).thenApplyAsync(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("then apply thread: " +Thread.currentThread().getName());
                System.out.println("I am in then apply");
                return s.concat(" after apply method");
            }
        }, executorService)
//       .thenAccept(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s.concat(" AFTER ACCEPT"));
//            }
//        });
        .thenRunAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("then run thread: " +Thread.currentThread().getName());
                System.out.println("I am in run method after completing the execution");
            }
        }, executorService).thenRunAsync(new Runnable() {
             @Override
             public void run() {
                 System.out.println("I am in second run async");
             }
        }, executorService);

        System.out.println(Thread.currentThread().getName());

//        System.out.println("Hello from main");
//        System.out.println("Hello from main2");
//        System.out.println("Hello from main3");

        System.out.println(cf1.get()); // blocking call

        System.out.println("Hello from main");
        System.out.println("Hello from main2");
        System.out.println("Hello from main3");

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);

        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                throw new RuntimeException("Test exception");
//                return "correct response";
            }
        })
//                .exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                System.out.println("Received exception: "+ throwable);
//                return "Default handling for exception";
//            }
//        })
//                .exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                System.out.println("2nd time Received exception: "+ throwable);
//                return "Default handling for exception";
//            }
//        })
                .handle(new BiFunction<String, Throwable, String>() {
            @Override
            public String apply(String s, Throwable throwable) {
                System.out.println("I am in handle method");
                System.out.println("res: "+ s);
                System.out.println("throwable: "+ throwable);
                return s == null ? "default" : s;
            }
        });

        System.out.println(cf3.get());
    }
}
