package com.github.sasachichito.period;

import java.time.LocalDateTime;
import static com.github.sasachichito.assertion.Assertion.*;

/**
 * The representation of period.
 */
public class Period {

    /**
     * The start datetime.
     */
    private LocalDateTime start;

    /**
     * The end datetime.
     */
    private LocalDateTime end;

    /**
     * Constructor.
     *
     * @param start the start datetime, not null
     * @param end the end datetime, not null
     */
    public Period(LocalDateTime start, LocalDateTime end) {

        expect(() -> start.isBefore(end),
            "start must be before end");

        this.start = start;
        this.end = end;
    }

    /**
     * Checks if the target datetime is within this period
     *
     * @param target the target datetime
     * @return true if target datetime is within this period, not null
     */
    public boolean between(LocalDateTime target) {

        if (target.isBefore(this.start)) {
            return false;
        }

        if (target.isAfter(this.end)) {
            return false;
        }

        return true;
    }
}
