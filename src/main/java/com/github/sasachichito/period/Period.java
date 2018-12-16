package com.github.sasachichito.period;

import java.time.LocalDateTime;
import static com.github.sasachichito.assertion.Assertion.*;

public class Period {

    private LocalDateTime start;
    private LocalDateTime end;

    public Period(LocalDateTime start, LocalDateTime end) {

        check(() -> start.isBefore(end),
            "start must be before end");

        this.start = start;
        this.end = end;
    }

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
