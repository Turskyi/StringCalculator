package io.github.turskyi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringCalculatorTest {

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertEquals (0, StringCalculator.add (""));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        assertEquals (8, StringCalculator.add ("1,2,5"));
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertEquals (6, StringCalculator.add ("1\n,2,3"));
    }

    @Test
    public final void whenNewLineAndComaIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertEquals (7, StringCalculator.add ("1,\n2,4"));
    }

    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        assertEquals (8, StringCalculator.add ("//;\n1;3;4"));
        assertEquals (6, StringCalculator.add ("//$\n1$2$3"));
        assertEquals (13, StringCalculator.add ("//@\n2@3@8"));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        assertEquals (3, StringCalculator.add ("3"));
    }

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            StringCalculator.add ("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull (exception);
        assertEquals ("Negatives not allowed: [-6, -18]", exception.getMessage ( ));
    }

    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        assertEquals (2, StringCalculator.add ("2,1001"));
    }

    @Test
    public final void whenDelimiterWithArbitraryLength() {
        assertEquals (6, StringCalculator.add ("//***\n1***2***3"));
    }

    @Test
    public final void allowForMultipleDelimiters() {
        assertEquals (6, StringCalculator.add ("//$,@\n1$2@3"));
    }

    @Test
    public final void allowMultipleDelimitersOfArbitraryLength() {
        assertEquals (6, StringCalculator.add ("//$$,@@\n1$$2@@3"));
    }
}