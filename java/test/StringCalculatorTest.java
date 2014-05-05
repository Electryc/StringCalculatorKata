import com.stringcalculatorproject.InvalidInputException;
import com.stringcalculatorproject.NegativeNumberException;
import com.stringcalculatorproject.StringCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zan on 16/04/2014.
 */
public class StringCalculatorTest {

    @Test
    public void an_empty_string_returns_0() {

        assertFalse(false);
    }

    @Test
    public void add_method_exists() {
        StringCalculator.add("");
        assertTrue(true);
    }

    @Test
    public void return_zero_for_empty_string() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void return_sum_for_one_number() {
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void return_sum_for_two_numbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void return_sum_for_three_numbers() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void accept_new_line_between_numbers() {
        StringCalculator.add("1\n2,3");
    }

    @Test
    public void return_sum_for_numbers_with_new_line() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test(expected = InvalidInputException.class)
    public void verify_wrong_comma_followed_by_new_line() {
        StringCalculator.add("1,\n");
    }

    @Test(expected = InvalidInputException.class)
    public void verify_wrong_new_line_followed_by_comma() {
        StringCalculator.add("1\n,");
    }

    @Test(expected = InvalidInputException.class)
    public void check_for_wrong_separator() {
        StringCalculator.add("1|2");
    }

    @Test (expected = NegativeNumberException.class)
    public void string_with_one_negative_number_throws_exception() {
        StringCalculator.add("-8");
    }

    @Test (expected = NegativeNumberException.class)
    public void string_with_multiple_negative_number_throws_exception() {
        StringCalculator.add("1,-6,7,-10\n9\n-8");
    }

    @Test
    public void string_with_numbers_bigger_than_1024_are_ignored() {
        assertEquals(2, StringCalculator.add("2,1025"));
        assertEquals(5, StringCalculator.add("5,2050"));
    }
}


