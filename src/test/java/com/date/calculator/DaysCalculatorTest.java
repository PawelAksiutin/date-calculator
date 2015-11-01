package com.date.calculator;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DaysCalculatorTest {

    //TODO to introduce JUnit parametrized
    // improve naming
    @Test
    public void subtractCase1() {
        //Case 1. 02/06/1983 - 22/06/1983: 19 days
        LocalDate startDate = LocalDate.of(1983, 6, 2);
        LocalDate endDate = LocalDate.of(1983, 6, 22);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        assertThat(numberOfDays, equalTo(19));
    }

    @Test
    public void subtractsCase2() {
        //Case 2. 04/07/1984 - 25/12/1984: 173 days
        LocalDate startDate = LocalDate.of(1984, 7, 4);
        LocalDate endDate = LocalDate.of(1984, 12, 25);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        assertThat(numberOfDays, equalTo(173));
    }

    @Test
    public void subtractsCase3() {
        //Case 3. 03/01/1989 - 03/08/1983: 1979 days
        LocalDate startDate = LocalDate.of(1989, 1, 3);
        LocalDate endDate = LocalDate.of(1983, 8, 3);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        assertThat(numberOfDays, equalTo(1979));
    }

    @Test
    public void subtractsCase4() {
        //Case 4. 07/11/1972 - 08/11/1972: 0 days
        LocalDate startDate = LocalDate.of(1972, 11, 7);
        LocalDate endDate = LocalDate.of(1972, 11, 8);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        assertThat(numberOfDays, equalTo(0));
    }

    @Test
    public void shouldReturn0ForSameDates() {
        // 07/11/1972 - 07/11/1972: 0 days
        LocalDate startDate = LocalDate.of(1972, 11, 7);
        LocalDate endDate = LocalDate.of(1972, 11, 7);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        assertThat(numberOfDays, equalTo(0));
    }

    @Test
    public void subtractsCase5() {
        //Case 5. 01/01/2000 - 03/01/2000: 1 day
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2000, 1, 3);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        assertThat(numberOfDays, equalTo(1));
    }

    @Test
    public void subtractsEdgeDates() {
        //Case 6. 01/01/1901 - 31/12/2999: 401400 days
        LocalDate startDate = LocalDate.of(1901, 1, 1);
        LocalDate endDate = LocalDate.of(2999, 12, 31);

        int numberOfDays = DaysCalculator.fullDaysBetween(startDate, endDate);

        int numberOfDaysCalculatedByJavaLibrary = (int) ChronoUnit.DAYS.between(startDate, endDate) - 1;
        assertThat(numberOfDays, equalTo(numberOfDaysCalculatedByJavaLibrary));
    }

}