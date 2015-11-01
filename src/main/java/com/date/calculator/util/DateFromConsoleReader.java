package com.date.calculator.util;

import com.date.calculator.date.SimpleLocalDate;
import com.date.calculator.date.SimpleLocalDateParseException;

import java.util.Scanner;

public class DateFromConsoleReader {

    public static final String ERROR_MESSAGE = "Date entered is incorrect. Please try again. You have %d more attempt(s).";

    public static SimpleLocalDate readWithRetry(final int retriesNumber) {
        int numTries = retriesNumber + 1;
        while (true) {
            try {
                return readDateFromConsole();
            } catch (SimpleLocalDateParseException e) {
                if (--numTries < 1) {
                    throw e;
                }
                System.err.println(String.format(ERROR_MESSAGE, numTries));
            }
        }
    }

    public static SimpleLocalDate readDateFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String stringDate = scanner.nextLine();
        return SimpleLocalDate.parse(stringDate);
    }
}