package com.date.calculator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Valid date format is DD/MM/YYYY e.g. 01/01/1972 or 1/1/1972");
        try {
            System.out.println("Please enter first date.");
            SimpleLocalDate date1 = DateFromConsoleReader.readWithRetry(2);

            System.out.println("Please enter second date.");
            SimpleLocalDate date2 = DateFromConsoleReader.readWithRetry(2);

            int numberOfDays = DaysCalculator.fullDaysBetween(date1, date2);
            System.out.println(String.format("%d day(s) between %s and %s", numberOfDays, date1, date2));
        } catch (SimpleLocalDateParseException e) {
            System.err.println("Application will exit.");
        }
    }
}
