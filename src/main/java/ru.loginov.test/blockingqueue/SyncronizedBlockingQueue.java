package ru.loginov.test.blockingqueue;

import java.util.ArrayList;
import java.util.List;

public class SyncronizedBlockingQueue<T> {

    private final int capacity;
    private final List<T> list;

    public SyncronizedBlockingQueue(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);
    }

    public synchronized void add(T e) throws InterruptedException {
        while (list.size() >= capacity) {
            wait();
        }
        list.add(e);
        System.out.println("added " + e);
        notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (list.isEmpty()) {
            wait();
        }
        T result = list.get(0);
        list.remove(0);
        System.out.println("got " + result);
        notify();
        return result;
    }

}
