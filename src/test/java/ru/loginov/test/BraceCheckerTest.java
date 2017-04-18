package ru.loginov.test;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BraceCheckerTest {

    private final BraceChecker checker = new BraceChecker();

    @Test
    public void test() {
        assertTrue(checker.check("()"));
        assertFalse(checker.check("([)]"));
        assertTrue(checker.check("()[]"));
        assertTrue(checker.check("([])"));
    }



}
