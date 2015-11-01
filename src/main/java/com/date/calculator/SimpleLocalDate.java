package com.date.calculator;

import java.time.format.DateTimeParseException;
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
            return new SimpleLocalDate(day, month, year);
        } catch (Exception e) {
            throw new DateTimeParseException(null, stringDate, scanner.radix());
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
