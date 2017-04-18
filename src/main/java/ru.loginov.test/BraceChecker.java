package ru.loginov.test;

import javafx.util.Pair;

import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

public class BraceChecker {

    private static final List<Pair<Character, Character>> BRACES = asList(
            new Pair<>('(', ')'),
            new Pair<>('[', ']'),
            new Pair<>('{', '}')
    );

    private Stack<Character> stack = new Stack<>();

    public boolean check(String line) {
        for (char c : line.toCharArray()) {
            Pair<Character, Character> pair = BRACES.stream()
                    .filter(it -> it.getKey().equals(c) || it.getValue().equals(c))
                    .findAny().orElse(null);
            if (pair == null) {
                continue;
            }
            Character left = pair.getKey();
            if (left.equals(c)) {
                stack.add(c);
            } else {
                Character peeked = stack.pop();
                if (!left.equals(peeked)) {
                    return false;
                }
            }
        }
        return true;
    }

}
