package com.date.calculator.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class SimpleLocalDateTest {

    private String date;
    private int day;
    private int month;
    private int year;

    public SimpleLocalDateTest(final String date, final int day, final int month, final int year) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"02/06/1983", 2, 6, 1983},
                {"04/07/1984", 4, 7, 1984},
                {"03/01/1989", 3, 1, 1989},
                {"01/01/2000", 1, 1, 2000},
                {"07/11/1972", 7, 11, 1972},
                {"07/11/1972", 7, 11, 1972},
                {"1/1/1901", 1, 1, 1901}
        });
    }

    @Test
    public void shouldCorrectlyParseValues() throws Exception {
        SimpleLocalDate slDate = SimpleLocalDate.parse(date);
        assertThat(slDate.getDay(), equalTo(day));
        assertThat(slDate.getMonth(), equalTo(month));
        assertThat(slDate.getYear(), equalTo(year));
    }
}