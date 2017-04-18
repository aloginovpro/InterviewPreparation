package ru.loginov.test.sort;

import java.util.ArrayList;
import java.util.List;

import static ru.loginov.test.sort.Common.randomList;

public class QuickSort {

    private static final int N = 10000;

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            List<Integer> random = randomList(N, N);
            List<Integer> sorted = sort(random);
        }
        System.out.println("took " + (System.currentTimeMillis() - now));
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
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
        result.addAll(sort(left));
        result.addAll(equal);
        result.addAll(sort(right));
        return result;
    }

}
