package ru.loginov.test;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted exception");
                        return;
                    }
                    System.out.println("doing smt..");
                    if (isInterrupted()) {
                        System.out.println("interrupted");
                        return;
                    }
                }
            }
        };
        t.start();

        Thread.sleep(1000);
        t.interrupt();

    }

}
