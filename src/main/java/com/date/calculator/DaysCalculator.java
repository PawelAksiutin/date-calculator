package com.date.calculator;

import java.time.LocalDate;

import static java.lang.Math.abs;

public class DaysCalculator {

    public static int fullDaysBetween(LocalDate startDateExclusive, LocalDate endDateExclusive) {
        int endDateJdn = JulianDayNumber.calculate(endDateExclusive);
        int startDateJdn = JulianDayNumber.calculate(startDateExclusive);
        int diffAbs = abs(endDateJdn - startDateJdn);
        return (diffAbs > 0) ? (diffAbs - 1) : diffAbs;
    }

}
