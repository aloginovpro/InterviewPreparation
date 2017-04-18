package ru.loginov.test.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Common {

    public static List<Integer> randomList(int n, int max) {
        Random r = new Random();
        List<Integer> result = new ArrayList<>(max);
        for (int i = 0; i < n; i++) {
            result.add(r.nextInt(max));
        }
        return result;
    }

}
