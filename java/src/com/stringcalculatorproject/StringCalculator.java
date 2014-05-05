package com.stringcalculatorproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String NUMBER_SEPARATORS = "[,\n]";
    private static final String VALID_INPUT_REGEX = "(\\d+)(((,|\\n)\\d+)+)?";
    private static final String INVALID_NEGATIVE_NUMBER_INPUT_REGEX = "(-\\d)";

    public static int add(String s) {
        if ("".equals(s)) {
            return 0;
        }

        checkNegativeNumbersFor(s);

        checkValidInputFor(s);

        String[] numbersStrings = s.split(NUMBER_SEPARATORS);
        int sum = sumFor(numbersStrings);
        return sum;

    }

    private static void checkNegativeNumbersFor(String s) {
        Pattern pattern = Pattern.compile(INVALID_NEGATIVE_NUMBER_INPUT_REGEX);
        Matcher matcher = pattern.matcher(s);
        StringBuilder negativeNumbers = new StringBuilder();
        while (matcher.find()) {
            negativeNumbers.append(" ").append(matcher.group());
        }

        if (!negativeNumbers.toString().isEmpty()) {
            throw (new NegativeNumberException("Negative numbers: " + negativeNumbers));
        }
    }

    private static void checkValidInputFor(String s) {
        if (!validInputFor(s)) {
            throw (new InvalidInputException("Invalid input."));
        }
    }

    private static boolean validInputFor(String s) {
        return s.matches(VALID_INPUT_REGEX);
    }

    private static int sumFor(String[] numbersStrings) {
        int sum = 0;
        for (String n : numbersStrings) {
            sum += toCappedInt(n);
        }
        return sum;
    }

    private static Integer toCappedInt(String n) {
        Integer number = Integer.valueOf(n);
        if(number >= 1024){
            return 0;
        }
        return number;
    }
}
