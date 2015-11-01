package com.date.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class JulianDayNumberTest {

    private String date;
    private int jdnExpected;

    public JulianDayNumberTest(final String date, final int jdnExpected) {
        this.date = date;
        this.jdnExpected = jdnExpected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"12/12/2012", 2456274},
                {"3/3/3333", 2938475},
                {"20/6/1756", 2362597},
                {"1/1/1600", 2305448}
        });
    }

    @Test
    public void shouldCorrectlyCalculateJulianDayNumber() {
        SimpleLocalDate slDate = SimpleLocalDate.parse(date);
        assertThat(JulianDayNumber.calculate(slDate), equalTo(jdnExpected));
    }
}