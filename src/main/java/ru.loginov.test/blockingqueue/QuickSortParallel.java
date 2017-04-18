package ru.loginov.test.blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.loginov.test.sort.Common.randomList;

public class QuickSortParallel {

    private static final int N = 1000000; //18000
    private static final AtomicInteger forkCounter = new AtomicInteger();

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            List<Integer> random = randomList(N, N);
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            List<Integer> sorted = forkJoinPool.invoke(new SortTask<>(random));
        }
        System.out.println("took " + (System.currentTimeMillis() - now) + ", forcCounter " + forkCounter.get());
    }

    private static class SortTask<T extends Comparable<T>> extends RecursiveTask<List<T>> {

        private final List<T> list;

        private SortTask(List<T> list) {
            this.list = list;
        }

        @Override
        protected List<T> compute() {
            return sort(list);
        }

        List<T> sort(List<T> list) {
            if (list.size() == 0 || list.size() == 1) {
                return list;
            }
            T midValue = list.get((list.size() - 1) / 2);
            List<T> left = new ArrayList<>();
            List<T> equal = new ArrayList<>();
            List<T> right = new ArrayList<>();
            for (T e : list) {
                int compare = e.compareTo(midValue);
                if (compare < 0) {
                    left.add(e);
                } else if (compare > 0) {
                    right.add(e);
                } else {
                    equal.add(e);
                }
            }
            ArrayList<T> result = new ArrayList<>();
            if (left.size() < N / 10 && right.size() < N / 10) {
                result.addAll(sort(left));
                result.addAll(equal);
                result.addAll(sort(right));
            } else {
                forkCounter.incrementAndGet();
                SortTask<T> leftTask = new SortTask<>(left);
                SortTask<T> rightTask = new SortTask<>(right);
                leftTask.fork();
                rightTask.fork();
                result.addAll(leftTask.join());
                result.addAll(equal);
                result.addAll(rightTask.join());
            }
            return result;
        }
    }



}
