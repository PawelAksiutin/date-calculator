package com.date.calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static void main(String[] args) {

        System.out.println("Valid date format id DD/MM/YYYY e.g. 07/11/1972");

        LocalDate date1 = null;
        LocalDate date2 = null;
        try {
            System.out.println("Please enter fist date.");
            date1 = readDateFromConsoleWithRetry();

            System.out.println("Please enter second date.");
            date2 = readDateFromConsoleWithRetry();
        } catch (DateTimeParseException e) {
            System.err.println("Application will exit.");
            return;
        }
        int numberOfDays = DaysCalculator.fullDaysBetween(date1, date2);
        System.out.println(numberOfDays + " days between " + date1.format(FORMATTER) + " and " + date2.format(FORMATTER) + " .");
    }

    private static LocalDate readDateFromConsole() {
        //todo to extract separate class
        Scanner scanner = new Scanner(System.in);
        String stringDate1 = scanner.nextLine();
        return LocalDate.parse(stringDate1, FORMATTER);
    }

    private static LocalDate readDateFromConsoleWithRetry() {
        int numTries = 3;
        while(true) {
            try {
                return readDateFromConsole();
            } catch (DateTimeParseException e) {
                if (--numTries < 1) {
                    throw e;
                }
                System.err.println("Date entered is incorrect. Please try again. You have " + numTries + " more attempt(s).");
            }
        }
    }
}
