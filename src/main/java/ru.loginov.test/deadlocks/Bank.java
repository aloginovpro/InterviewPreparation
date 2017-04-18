package ru.loginov.test.deadlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {

    private static final Random random = new Random();

    private final List<Account> accounts = new ArrayList<>();

    public Bank() {
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account(i));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        for (int i = 0; i < 5; i++) {
            new Thread("Thread " + i) {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        Account first = bank.accounts.get(random.nextInt(bank.accounts.size()));
                        Account second = bank.accounts.get(random.nextInt(bank.accounts.size()));
                        if (first.id != second.id) {
                            synchronized (first.id > second.id ? first : second) {
                                synchronized (first.id > second.id ? second : first) {
                                    first.addValue(-1);
                                    second.addValue(1);
                                }
                            }
                        }
                    }
                    System.out.println("finished");
                }
            }.start();
        }
        Thread.sleep(1000);
        int sum = 0;
        for (Account account : bank.accounts) {
            System.out.println(account.getValue());
            sum += account.getValue();
        }
        System.out.println("sum=" + sum);
    }

}
