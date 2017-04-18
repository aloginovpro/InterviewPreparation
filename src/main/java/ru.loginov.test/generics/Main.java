package ru.loginov.test.generics;

public class Main {

    static class A {
        void foo() {}
    }

    static class B extends A {
        void bar() {}
    }

    public static void main(String[] args) {
        B[] bs = new B[5];
        A[] as = bs;
        as[0] = new A();
        for (B b : bs) {
            if (b != null) {
                b.bar();
            }
        }
    }

}
