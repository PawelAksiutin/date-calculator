package com.date.calculator;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateFromConsoleReaderTest {

    @Test
    public void shouldCorrectlyReadWithRetry1() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("11/12/2312".getBytes());
        System.setIn(in);

        LocalDate date = DateFromConsoleReader.readWithRetry(2);

        assertThat(date.getDayOfMonth(), equalTo(11));
        assertThat(date.getMonth().getValue(), equalTo(12));
        assertThat(date.getYear(), equalTo(2312));
    }

    @Test
    public void shouldCorrectlyReadWithRetry2() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("3/9/1735".getBytes());
        System.setIn(in);

        LocalDate date = DateFromConsoleReader.readWithRetry(0);

        assertThat(date.getDayOfMonth(), equalTo(3));
        assertThat(date.getMonth().getValue(), equalTo(9));
        assertThat(date.getYear(), equalTo(1735));
    }

    @Test(expected = DateTimeParseException.class)
    public void shouldReadWithRetryThrowExceptionWhenWrongInputOneTimeWithZeroLimit() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Bad date".getBytes());
        System.setIn(in);

        DateFromConsoleReader.readWithRetry(0);
    }

    @Test
    public void shouldCorrectlyReadDateFromConsole1() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("11/12/2312".getBytes());
        System.setIn(in);

        LocalDate date = DateFromConsoleReader.readDateFromConsole();

        assertThat(date.getDayOfMonth(), equalTo(11));
        assertThat(date.getMonth().getValue(), equalTo(12));
        assertThat(date.getYear(), equalTo(2312));
    }

    @Test
    public void shouldCorrectlyReadDateFromConsole2() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("3/9/1735".getBytes());
        System.setIn(in);

        LocalDate date = DateFromConsoleReader.readDateFromConsole();

        assertThat(date.getDayOfMonth(), equalTo(3));
        assertThat(date.getMonth().getValue(), equalTo(9));
        assertThat(date.getYear(), equalTo(1735));
    }

    @Test(expected = DateTimeParseException.class)
    public void shouldReadDateFromConsoleThrowExceptionWhenWrongInput() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Bad date".getBytes());
        System.setIn(in);

        DateFromConsoleReader.readDateFromConsole();
    }

    @Test(expected = DateTimeParseException.class)
    public void shouldReadDateFromConsoleThrowExceptionWhenWrongDateFormat() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("12-12-2012".getBytes());
        System.setIn(in);

        DateFromConsoleReader.readDateFromConsole();
    }

    @After
    public final void tearDown() {
        System.setIn(System.in);
    }
}