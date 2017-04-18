package ru.loginov.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedMapTest {

    private static final long MAX = 1000000;
    private static final long THREADS = 10;

    public static void main(String[] args) {
        Map<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();
        Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < MAX; j++) {
                    synchronizedMap.get(j);
                }
            }));
        }


        long now = System.currentTimeMillis();
        threads.forEach(Thread::start);
        threads.forEach(it -> {
            try {
                it.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("took " + (System.currentTimeMillis() - now));


    }

}
