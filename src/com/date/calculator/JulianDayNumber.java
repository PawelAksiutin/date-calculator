package com.date.calculator;

import java.time.LocalDate;

public class JulianDayNumber {

    // https://en.wikipedia.org/wiki/Julian_day

    public static int calculate(LocalDate date) {
        int a = calculateA(date.getMonthValue());
        int y = calculateY(date.getYear(), a);
        int m = calculateM(date.getMonthValue(), a);
        int addend1 = ((153 * m) + 2) / 5;
        int addend2 = y / 4;
        return date.getDayOfMonth() + addend1 + (365 * y) + addend2 - 32083;
    }

    private static int calculateA(final int month) {
        return (14 - month) / 12;
    }

    private static int calculateY(final int year, final int a) {
        return year + 4800 - a;
    }

    private static int calculateM(final int month, final int a) {
        return month + (12 * a) - 3;
    }
}