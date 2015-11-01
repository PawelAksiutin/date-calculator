package com.date.calculator.date;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleLocalDate {
    private int day;
    private int month;
    private int year;

    private SimpleLocalDate(final int day, final int month, final int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static SimpleLocalDate parse(final String stringDate) {
        Scanner scanner = new Scanner(stringDate);
        scanner.useDelimiter("/");
        try {
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            validateDay(day);
            validateMonth(month);
            return new SimpleLocalDate(day, month, year);
        } catch (NoSuchElementException e) {
            throw new SimpleLocalDateParseException(e.getMessage(), e.getCause());
        }
    }

    private static void validateDay(final int day) {
        if ((day < 1) || day > 31) {
            throw new SimpleLocalDateParseException("Day out of range.");
        }
    }

    private static void validateMonth(final int month) {
        if ((month < 1) || month > 12) {
            throw new SimpleLocalDateParseException("Month out of range.");
        }
    }
    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s", day, month, year);
    }
}
