package com.date.calculator;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DaysCalculatorTest {

    @Test
    public void substractsCase1() {
        //Case 1. 02/06/1983 - 22/06/1983: 19 days
        LocalDate beginDate = LocalDate.of(1983,6,2);
        LocalDate endDate = LocalDate.of(1983,6,22);
        int numberOfDays = DaysCalculator.fullDaysBetween(beginDate, endDate);
        assertThat(numberOfDays, equalTo(19));
    }

    @Test
    public void substractsCase2() {
        //Case 2. 04/07/1984 - 25/12/1984: 173 days
        LocalDate beginDate = LocalDate.of(1984,7,4);
        LocalDate endDate = LocalDate.of(1984,12,25);
        int numberOfDays = DaysCalculator.fullDaysBetween(beginDate, endDate);
        assertThat(numberOfDays, equalTo(173));
    }

    @Test
    public void substractsCase3() {
        //Case 3. 03/01/1989 - 03/08/1983: 1979 days
        LocalDate beginDate = LocalDate.of(1989,1,3);
        LocalDate endDate = LocalDate.of(1983,8,3);
        int numberOfDays = DaysCalculator.fullDaysBetween(beginDate, endDate);
        assertThat(numberOfDays, equalTo(1979));
    }

}