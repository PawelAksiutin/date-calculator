package com.date.calculator;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class JulianDayNumberTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");

    private String date;
    private int jdnExpected;

    public JulianDayNumberTest(final String date, final int jdnExpected) {
        this.date = date;
        this.jdnExpected = jdnExpected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                { "12/12/2012", 2456274 },
                { "3/3/3333", 2938475 },
                { "20/6/1756", 2362597 },
                { "1/1/1600", 2305448 }
        });
    }

    @Test
    public void shouldCorrectlyCalculateJulianDayNumber() {
        LocalDate localDate = LocalDate.parse(date, FORMATTER);
        assertThat(JulianDayNumber.calculate(localDate), equalTo(jdnExpected));
    }

}