package ru.loginov.test.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        SyncronizedBlockingQueue<Integer> queue = new SyncronizedBlockingQueue<>(2);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        queue.put(1);
        System.out.println("added 1");
        queue.put(2);
        System.out.println("added 2");
        queue.put(3);
        System.out.println("added 3");
        queue.put(4);
        System.out.println("added 4");


//        Random random = new Random();
//        new Thread(() -> {
//            while (true) {
//                try {
//                    queue.add(random.nextInt(10));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                try {
//                    queue.poll();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }

}
