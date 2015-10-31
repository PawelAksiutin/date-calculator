package com.date.calculator;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FullDaysCalculatorTest {

    @Test
    public void substractsCase1() {
        //02/06/1983 - 22/06/1983: 19 days
        LocalDate beginDate = LocalDate.of(1983,6,2);
        LocalDate endDate = LocalDate.of(1983,6,22);
        int numberOfDays = DaysCalculator.fullDaysBetween(beginDate, endDate);
        assertThat(numberOfDays, equalTo(19));
    }

}