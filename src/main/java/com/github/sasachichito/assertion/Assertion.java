package com.github.sasachichito.assertion;

import java.util.function.BooleanSupplier;

/**
 * please static import this class.
 */
public class Assertion {

    /**
     * There is no problem if BooleanSupplier returns true,
     * otherwise there is a problem.
     *
     * @param booleanSupplier
     * @param message
     */
    public static void check(BooleanSupplier booleanSupplier, String message) {
        if (booleanSupplier.getAsBoolean()) {
            return; // No problem.
        }
        throw new IllegalArgumentException(message);
    }
}
