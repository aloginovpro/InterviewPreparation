package ru.loginov.test;

import java.util.Random;
import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = new Random().nextInt();
                try {
                    for (int j = 0; j < 10; j++) {
                        Thread.sleep(100);
                        System.out.println("counting " + i);
                    }
                } catch (Exception e) {
                    System.out.println("interrupted !!!!");
                    e.printStackTrace();
                    throw e;
                }
                return i;
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(callable);
        Thread.sleep(500);
        future.cancel(false);
//        while (!future.isDone()) {
//            Thread.sleep(100);
//            System.out.println("waiting...");
//        }
        System.out.println(future.get());

    }

}
