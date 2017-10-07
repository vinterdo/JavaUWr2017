package test.java.pl.vinterdo;

import main.java.pl.vinterdo.RomanNumberConverter;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class RomanNumberConverterTest {

    @Test
    public void simpleTests() {
        assertThat("IX", is(equalTo(RomanNumberConverter.getRoman(9))));
        assertThat("CXXIII", is(equalTo(RomanNumberConverter.getRoman(123))));
        assertThat("CDXCIX", is(equalTo(RomanNumberConverter.getRoman(499))));
        assertThat("DCLXVI", is(equalTo(RomanNumberConverter.getRoman(666))));
        assertThat("I", is(equalTo(RomanNumberConverter.getRoman(1))));
        assertThat("M", is(equalTo(RomanNumberConverter.getRoman(1000))));
        assertThat("MMMMCMXCIX", is(equalTo(RomanNumberConverter.getRoman(4999))));
        assertThat("MCCCXXXVII", is(equalTo(RomanNumberConverter.getRoman(1337))));
        assertThat("MMXLVIII", is(equalTo(RomanNumberConverter.getRoman(2048))));
    }

    @Test
    public void checkOverRangeFail() {
        try {
            RomanNumberConverter.getRoman(5000);
        }
        catch (IllegalArgumentException ignored) {
            return;
        }
        fail();
    }

    @Test
    public void checkOverRangeFail2() {
        try {
            RomanNumberConverter.getRoman(6000);
        }
        catch (IllegalArgumentException ignored) {
            return;
        }
        fail();
    }

    @Test
    public void checkUnderRangeFail() {
        try {
            RomanNumberConverter.getRoman(0);
        }
        catch (IllegalArgumentException ignored) {
            return;
        }
        fail();
    }

    @Test
    public void checkNegativeFail() {
        try {
            RomanNumberConverter.getRoman(-123);
        }
        catch (IllegalArgumentException ignored) {
            return;
        }
        fail();
    }
}