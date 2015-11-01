package com.date.calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("Valid date format is DD/MM/YYYY e.g. 07/11/1972 or 1/1/1972");
        LocalDate date1 = null;
        LocalDate date2 = null;
        try {
            System.out.println("Please enter fist date.");
            date1 = DateFromConsoleReader.readWithRetry(2);

            System.out.println("Please enter second date.");
            date2 = DateFromConsoleReader.readWithRetry(2);
        } catch (DateTimeParseException e) {
            System.err.println("Application will exit.");
            return;
        }
        int numberOfDays = DaysCalculator.fullDaysBetween(date1, date2);
        System.out.println(String.format("%d day(s) between %s and %s .", numberOfDays, date1.format(FORMATTER), date2.format(FORMATTER)));
    }
}
