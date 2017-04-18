package ru.loginov.test.forkjoin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node {
    private final List<Node> children = new ArrayList<>();
    private final int value;

    public Node(int value) {
        this.value = value;
    }

    Collection<Node> getChildren() {
        return children;
    }

    void addChild(Node node) {
        children.add(node);
    }

    long getValue() {
        return value;
    }


}