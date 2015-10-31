package com.date.calculator;

import java.time.LocalDate;

import static java.lang.Math.abs;

public class DaysCalculator {

    public static int fullDaysBetween(LocalDate startDateExclusive, LocalDate endDateExclusive) {
        int endDateJdn = JulianDayNumber.calculate(endDateExclusive);
        int startDateJdm = JulianDayNumber.calculate(startDateExclusive);
        return abs(endDateJdn - startDateJdm) - 1;
    }

}
