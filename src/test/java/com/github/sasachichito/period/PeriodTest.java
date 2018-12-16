package com.github.sasachichito.period;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {

    @Test
    void creationSuccess() {
        LocalDateTime start = LocalDateTime.of(2018,12,1,10,0,0);
        LocalDateTime end = LocalDateTime.of(2018,12,1,12,0,0);
        new Period(start, end);
    }

    @ParameterizedTest
    @MethodSource("badStartEndProvider")
    void creationFailed(LocalDateTime start, LocalDateTime end) {
        assertThrows(IllegalArgumentException.class, () -> new Period(start, end));
    }
    static Stream<Arguments> badStartEndProvider() {
        return Stream.of(

            Arguments.of( // start == end
                LocalDateTime.of(2018,12,1,10,0,0),
                LocalDateTime.of(2018,12,1,10,0,0)
            ),
            Arguments.of( // start > end
                LocalDateTime.of(2018,12,2,10,0,0),
                LocalDateTime.of(2018,12,1,10,0,0)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("periodTargetProvider")
    void betweenTrue(LocalDateTime start, LocalDateTime end, LocalDateTime target) {
        Period period = new Period(start, end);
        assertTrue(period.between(target));
    }
    static Stream<Arguments> periodTargetProvider() {
        return Stream.of(
            Arguments.of( // start < target < end
                LocalDateTime.of(2018,12,1,10,0,0),
                LocalDateTime.of(2018,12,2,10,0,0),
                LocalDateTime.of(2018,12,1,22,0,0)
            ),
            Arguments.of( // start <= target < end
                LocalDateTime.of(2018,12,1,10,0,0),
                LocalDateTime.of(2018,12,2,10,0,0),
                LocalDateTime.of(2018,12,1,10,0,0)
            ),
            Arguments.of( // start < target <= end
                LocalDateTime.of(2018,12,1,10,0,0),
                LocalDateTime.of(2018,12,2,10,0,0),
                LocalDateTime.of(2018,12,2,10,0,0)
            )
        );
    }
}