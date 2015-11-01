package com.date.calculator.util;

import com.date.calculator.date.SimpleLocalDate;

public class JulianDayNumber {

    // Julian Day Number algorithm with O(1) complexity
    // https://en.wikipedia.org/wiki/Julian_day
    // valid for dates starting from a Gregorian calendar
    public static int calculate(SimpleLocalDate date) {
        int a = calculateA(date.getMonth());
        int y = calculateY(date.getYear(), a);
        int m = calculateM(date.getMonth(), a);
        int entier1 = ((153 * m) + 2) / 5;
        int entier2 = y / 4;
        int entier3 = y / 100;
        int entier4 = y / 400;
        return date.getDay() + entier1 + (365 * y) + entier2 - entier3 + entier4 - 32045;
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