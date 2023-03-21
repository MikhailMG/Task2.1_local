package org.example2;

public class StringRandomGenerator {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789";
    private static final String ALPHA_NUMERIC_SPESHIAL_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789!@#%^&*()<>?|";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    public static String randomAlphaNumericSpesh(int count) {
        StringBuilder builder1 = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_SPESHIAL_STRING.length());
            builder1.append(ALPHA_NUMERIC_SPESHIAL_STRING.charAt(character));
        }
        return builder1.toString();
    }
}