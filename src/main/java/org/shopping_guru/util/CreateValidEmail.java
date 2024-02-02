package org.shopping_guru.util;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateValidEmail {

    private static final Pattern VALID_EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9_-]+.[a-zA-Z]+");

    private CreateValidEmail() {};

    public static boolean isValidEmail(String emailToValidate) {
        if (StringUtils.isBlank(emailToValidate)) {
            return false;
        }

        Matcher matcher = VALID_EMAIL_PATTERN.matcher(emailToValidate);

        return matcher.matches();
    }
}
