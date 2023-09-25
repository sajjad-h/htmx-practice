package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX =
        "^[A-Za-z0-9+_.-]+@(.+)$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
