package ru.loginov.test.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;

public class MergeSort {

    public static void main(String[] args) {
        List<Integer> sorted = sort(asList(1, 3, 3, 2, 4, -1));
        System.out.println(join(sorted, ", "));
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.isEmpty() || list.size() == 1) {
            return list;
        }
        List<T> listLeft = sort(list.subList(0, list.size() / 2));
        List<T> listRight = sort(list.subList(list.size() / 2, list.size()));

        List<T> result = new ArrayList<>(list.size());

        Iterator<T> iterLeft = listLeft.iterator();
        Iterator<T> iterRight = listRight.iterator();
        T left = null;
        T right = null;
        while (true) {
            if (left == null && iterLeft.hasNext()) {
                left = iterLeft.next();
            }
            if (right == null && iterRight.hasNext()) {
                right = iterRight.next();
            }
            if (left == null && right == null) {
                break;
            }
            if (left == null) {
                result.add(right);
                right = null;
            } else if (right == null) {
                result.add(left);
                left = null;
            } else {
                if (left.compareTo(right) < 0) {
                    result.add(left);
                    left = null;
                } else {
                    result.add(right);
                    right = null;
                }
            }
        }

        return result;
    }

}
