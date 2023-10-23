package baseball.util;

import java.util.regex.Pattern;

public class Validation {
    private static final String REGEXP_PATTERN_NUMBER = "^\\d*$";

    /**
     * userInput은 문자열 앞 뒤 공백이 제거된 문자열만 들어온다.
     */
    public static boolean checkUserInput(String userInput) {
        if (userInput.length() != 3) {
            return false;
        }

        if (userInput.contains("0")) {
            return false;
        }

        if (!checkDuplicatedNumber(userInput)) {
            return false;
        }

        return Pattern.matches(REGEXP_PATTERN_NUMBER, userInput);
    }

    public static boolean checkRestartOrExitNumber(String input) {
        return (input.equals("1") || input.equals("2"));
    }
    public static boolean checkDuplicatedNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (input.indexOf(target) != i) {
                return false;
            }
        }

        return true;
    }

}
