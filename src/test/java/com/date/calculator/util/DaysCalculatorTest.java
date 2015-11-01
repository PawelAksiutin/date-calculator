package com.date.calculator.util;

import com.date.calculator.date.SimpleLocalDate;
import com.date.calculator.util.DaysCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class DaysCalculatorTest {

    private String date1;
    private String date2;
    private int numberOfDays;

    public DaysCalculatorTest(final String date1, final String date2, final int numberOfDays) {
        this.date1 = date1;
        this.date2 = date2;
        this.numberOfDays = numberOfDays;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"02/06/1983", "22/06/1983", 19},
                {"04/07/1984", "25/12/1984", 173},
                {"03/01/1989", "03/08/1983", 1979},
                {"01/01/2000", "03/01/2000", 1},
                {"07/11/1972", "08/11/1972", 0},
                {"07/11/1972", "07/11/1972", 0},
                {"01/01/1901", "31/12/2999", 401400}
        });
    }

    @Test
    public void shouldCorrectlyCalculateJulianDayNumber() {
        SimpleLocalDate slDate1 = SimpleLocalDate.parse(date1);
        SimpleLocalDate slDate2 = SimpleLocalDate.parse(date2);
        assertThat(DaysCalculator.fullDaysBetween(slDate1, slDate2), equalTo(numberOfDays));
    }
}