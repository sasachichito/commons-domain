package com.github.sasachichito.assertion;

import org.junit.jupiter.api.Test;
import static com.github.sasachichito.assertion.Assertion.*;
import static org.junit.jupiter.api.Assertions.*;

class AssertionTest {

    @Test
    void checkNoProblem() {
        check(() -> true, "err");
    }

    @Test
    void checkProblem() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> check(() -> false, "err"));
        assertEquals("err", exception.getMessage());
    }

    @Test
    void checkMessageNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> check(() -> false, null));
        assertEquals("err message required", exception.getMessage());
    }

    @Test
    void checkCodeNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> check(null, "err"));
        assertEquals("code required", exception.getMessage());
    }

    @Test
    void checkCodeAndMessageNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> check(null, null));
        assertEquals("code required", exception.getMessage());
    }
}