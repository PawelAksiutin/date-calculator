package com.date.calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateFromConsoleReader {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final Scanner scanner = new Scanner(System.in);
    public static final String ERROR_MESSAGE = "Date entered is incorrect. Please try again. You have %d more attempt(s).";

    public static LocalDate readWithRetry(final int retriesNumber) {
        int numTries = retriesNumber;
        while (true) {
            try {
                return readDateFromConsole();
            } catch (DateTimeParseException e) {
                if (--numTries < 1) {
                    throw e;
                }
                System.err.println(String.format(ERROR_MESSAGE, numTries));
            }
        }
    }

    public static LocalDate readDateFromConsole() {
        String stringDate1 = scanner.nextLine();
        return LocalDate.parse(stringDate1, FORMATTER);
    }
}