package ru.loginov.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Lock read = lock.readLock();
    private static final Lock write = lock.writeLock();

    //writer can acquire the read lock, but not vice-versa
    public static void main(String[] args) {
        write.lock();
        System.out.println("write locked1");
        write.lock();
        System.out.println("write locked2");
        read.lock();
        System.out.println("read locked1");
        read.lock();
        System.out.println("read locked2");
    }

    public static void main1(String[] args) throws InterruptedException {
        new Thread("writer") {
            @Override
            public void run() {
                write.lock();
                System.out.println("write locked");
            }
        }.start();
        Thread.sleep(1000);
        read.lock();
        System.out.println("read lock");
    }

}
