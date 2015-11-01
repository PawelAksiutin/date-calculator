package com.date.calculator.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SimpleLocalDateWrongInputTest {

    private String date;

    public SimpleLocalDateWrongInputTest(final String date) {
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection wrongData() {
        return Arrays.asList(new Object[][]{
                {"Bad date"},
                {"Another bad date"},
                {"//"},
                {"/01/2000"},
                {"07//1972"},
                {"01/01/"},
                {"sad/01/2000"},
                {"07/qwe/1972"},
                {"01/01/qweq"},
                {"/sda/2000"},
                {"ds//1972"},
                {"01/sd/"},
                {"32/5/2999"},
                {"0/5/2999"},
                {"15/13/2999"},
                {"15/0/2999"}
        });
    }

    @Test(expected = SimpleLocalDateParseException.class)
    public void shouldThrowExceptionWhenWrongInput() throws Exception {
        SimpleLocalDate.parse(date);
    }

}