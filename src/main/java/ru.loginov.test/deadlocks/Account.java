package ru.loginov.test.deadlocks;

public class Account {

    public final int id;
    private int value;

    public Account(int id) {
        this.id = id;
    }

    public void addValue(int value) {
        this.value += value;
    }

    public int getValue() {
        return value;
    }

}
