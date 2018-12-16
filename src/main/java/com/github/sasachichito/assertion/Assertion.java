package com.github.sasachichito.assertion;

import java.util.function.BooleanSupplier;

/**
 * Provide check method for specific-domain.
 * <p>
 * Use static import this class when using.
 */
public class Assertion {

    /**
     * Checks code.
     * <p>
     * When code returns false, there is a problem.
     * <pre>{@code
     * check(() -> start.isBefore(end),
     *     "start must be before end");
     * }</pre>
     *
     * @param code the code to be checked, not null
     * @param message the message for exception, not null, not empty
     * @throws IllegalArgumentException when {@code code.getAsBoolean() == false}
     */
    public static void check(BooleanSupplier code, String message) throws IllegalArgumentException {

        if (code == null) {
            throw new IllegalArgumentException("code required");
        }

        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("err message required");
        }

        if (code.getAsBoolean()) {
            return; // No problem.
        }

        throw new IllegalArgumentException(message);
    }
}
