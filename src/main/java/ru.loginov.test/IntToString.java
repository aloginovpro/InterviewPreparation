package ru.loginov.test;

public class IntToString {

    public static void main(String[] args) {
        int i = Integer.MIN_VALUE - 2;
        System.out.println(toStr(i));
        System.out.println(Integer.toBinaryString(i));
    }

    public static String toStr(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 31; j >= 0; j--) {
            int b = i & (1 << j);
            sb.append(b == 0 ? "0" : "1");
        }
        return sb.toString();
    }

}
