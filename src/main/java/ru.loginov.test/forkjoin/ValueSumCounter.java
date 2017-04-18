package ru.loginov.test.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Long> {
    private final Node node;

    public ValueSumCounter(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<ValueSumCounter> subTasks = new ArrayList<>();

        for(Node child : node.getChildren()) {
            ValueSumCounter task = new ValueSumCounter(child);
            task.fork(); // запустим асинхронно
            subTasks.add(task);
        }
        System.out.println(Thread.currentThread().getName());
        for(ValueSumCounter task : subTasks) {
            sum += task.join(); // дождёмся выполнения задачи и прибавим результат
        }

        return sum;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.addChild(node2);
        node1.addChild(node3);
        for (int i = 0; i < 1000; i++) {
            node2.addChild(new Node(i));
        }
        Long result = new ForkJoinPool(5).invoke(new ValueSumCounter(node1));
        System.out.println(result);
    }

}