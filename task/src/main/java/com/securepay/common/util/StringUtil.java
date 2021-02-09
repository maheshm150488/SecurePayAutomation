package com.securepay.common.util;

import java.util.Random;

public class StringUtil {

    private static Random rnd = new Random();
    private static final String CHAR_LENGTH = "10";
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String MOBILE_SALT_CHARS = "0123456789";

    public static String generateRandomNumbers() {
	StringBuilder randomString = new StringBuilder();
	while (randomString.length() < Integer.parseInt(CHAR_LENGTH)) {
	    float random = rnd.nextFloat();
	    int index = (int) (random * MOBILE_SALT_CHARS.length());
	    randomString.append(MOBILE_SALT_CHARS.charAt(index));
	}
	return randomString.toString();
    }

    public static String generateRandomText() {
	StringBuilder randomString = new StringBuilder();
	while (randomString.length() < Integer.parseInt(CHAR_LENGTH)) {
	    float random = rnd.nextFloat();
	    int index = (int) (random * CHARS.length());
	    randomString.append(CHARS.charAt(index));
	}
	return randomString.toString();
    }

    public static boolean isNullorEmpty(String value) {
	return !(value != null && !"".equals(value));
    }

    public static void main(String[] args) {
	System.out.println(generateRandomNumbers());
    }
}
