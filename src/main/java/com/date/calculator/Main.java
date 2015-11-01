package com.date.calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("Valid date format is DD/MM/YYYY e.g. 07/11/1972 or 1/1/1972");
        try {
            System.out.println("Please enter first date.");
            LocalDate date1 = DateFromConsoleReader.readWithRetry(2);

            System.out.println("Please enter second date.");
            LocalDate date2 = DateFromConsoleReader.readWithRetry(2);

            int numberOfDays = DaysCalculator.fullDaysBetween(date1, date2);
            System.out.println(String.format("%d day(s) between %s and %s .", numberOfDays, date1.format(FORMATTER), date2.format(FORMATTER)));
        } catch (DateTimeParseException e) {
            System.err.println("Application will exit.");
        }
    }
}
