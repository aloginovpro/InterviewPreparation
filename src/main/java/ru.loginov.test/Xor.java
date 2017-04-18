package ru.loginov.test;

public class Xor {

    public static void main(String[] args) {
        int[] list = new int[] {1, 2, 3, 2, 1, 3, 0};
        int result = 0;
        for (int i : list) {
            result ^= i;
        }
        System.out.println(result);
    }

}
