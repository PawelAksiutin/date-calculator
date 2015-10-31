package com.date.calculator;

import java.time.LocalDate;

public class JulianDayNumber {

    // https://en.wikipedia.org/wiki/Julian_day

    // valid for dates starting from a Gregorian calendar
    public static int calculate(LocalDate date) {
        int a = calculateA(date.getMonthValue());
        int y = calculateY(date.getYear(), a);
        int m = calculateM(date.getMonthValue(), a);
        int entier1 = ((153 * m) + 2) / 5;
        int entier2 = y / 4;
        int entier3 = y / 100;
        int entier4 = y / 400;
        return date.getDayOfMonth() + entier1 + (365 * y) + entier2 - entier3 + entier4 - 32045;
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