package io.github.turskyi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int add(final @NotNull String numbers) {
        String delimiter = ",|\n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith ("//")) {
            int delimiterIndex = numbers.indexOf ("//") + 2;
            boolean isDigitAfterComa = Character.isDigit (numbers.charAt (numbers.indexOf (",") + 1));
            boolean
                    isSingleDelimiter =
                    numbers.charAt (delimiterIndex) != numbers.charAt (delimiterIndex + 1) && numbers.charAt (delimiterIndex + 1) != ',' && isDigitAfterComa;
            if (isSingleDelimiter) {
                delimiter = numbers.substring (delimiterIndex, delimiterIndex + 1);
                numbersWithoutDelimiter = numbers.substring (numbers.indexOf ("\n") + 1);
            } else if (delimiterIndex + 1 <= numbers.length ( ) - 1 && numbers.charAt (delimiterIndex) == numbers.charAt (delimiterIndex + 1) && isDigitAfterComa) {
                StringBuilder longDelimiter = new StringBuilder ( );
                longDelimiter.append (numbers.charAt (delimiterIndex));
                for (int i = delimiterIndex; i < numbers.length ( ); i++) {
                    if (numbers.charAt (i) == numbers.charAt (i + 1)) {
                        longDelimiter.append (i + 1);
                    } else {
                        break;
                    }
                }
                delimiter = numbers.substring (delimiterIndex, delimiterIndex + longDelimiter.length ( ));
                numbersWithoutDelimiter = numbers.substring (numbers.indexOf ("\n") + 1);
            } else {
                int firstDigitIndex = numbers.indexOf ("\n") + 1;
                StringBuilder sb = new StringBuilder ( );
                for (int i = firstDigitIndex; i < numbers.length ( ); i++) {
                    if (Character.isDigit (numbers.charAt (i))) {
                        sb.append (numbers.charAt (i));
                    } else if (Character.isDigit (numbers.charAt (i - 1))) {
                        sb.append (',');
                    }
                }
                numbersWithoutDelimiter = sb.toString ( );
            }
        }
        return add (numbersWithoutDelimiter, delimiter);
    }

    private static int add(final @NotNull String numbers, final @NotNull String delimiter) {
        int returnValue = 0;
        String[] numbersArray;
        if (delimiter.startsWith (",")) {
            numbersArray = numbers.split (delimiter);
        } else {
            numbersArray = numbers.split (java.util.regex.Pattern.quote (delimiter));
        }
        List<Integer> negativeNumbers = new ArrayList<> ( );
        for (String number : numbersArray) {
            if (!number.trim ( ).isEmpty ( )) {
                int numberInt = Integer.parseInt (number.trim ( ));
                if (numberInt < 0) {
                    negativeNumbers.add (numberInt);
                } else if (numberInt <= 1000) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size ( ) > 0) {
            throw new RuntimeException ("Negatives not allowed: " + negativeNumbers);
        }
        return returnValue;
    }
}
