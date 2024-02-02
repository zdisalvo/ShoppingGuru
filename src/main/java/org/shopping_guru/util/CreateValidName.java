package org.shopping_guru.util;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateValidName {

    //TODO validate name
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("([a-zA-Z '.-])+");

    //String regex = "^[A-Z][a-zA-Z.'-]*$";

    private CreateValidName() {}

    public static boolean isValidName(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }
        Matcher matcher = VALID_NAME_PATTERN.matcher(stringToValidate);

        return matcher.matches();

        //return !INVALID_NAME_PATTERN.matcher(stringToValidate).find();
    }


}
