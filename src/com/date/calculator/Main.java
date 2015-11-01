package com.date.calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        System.out.println("Valid date format id DD/MM/YYYY e.g. 07/11/1972");

        LocalDate date1 = null;
        LocalDate date2 = null;
        try {
            System.out.println("Please enter fist date.");
            date1 = DateFromConsoleReader.readWithRetry(3);

            System.out.println("Please enter second date.");
            date2 = DateFromConsoleReader.readWithRetry(3);
        } catch (DateTimeParseException e) {
            System.err.println("Application will exit.");
            return;
        }
        int numberOfDays = DaysCalculator.fullDaysBetween(date1, date2);
        System.out.println(numberOfDays + " day(s) between " + date1.format(FORMATTER) + " and " + date2.format(FORMATTER) + " .");
    }

}
