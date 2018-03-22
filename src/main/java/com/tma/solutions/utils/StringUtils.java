package com.tma.solutions.utils;

/**
 * Utility class for String processing.
 *
 * @author vnminh
 */
public final class StringUtils {

    /**
     * Prevents instantiate.
     */
    private StringUtils() {
    }

    /**
     * Checks if string is null and not empty.
     *
     * @param str the string.
     * @return true if not null and empty.
     */
    public static boolean isNotNullAndNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    /**
     * Checks if the String contains only Unicode digits.
     *
     * @param cs string
     * @return true if string contains only digit.
     */
    public static boolean isNumeric(String cs) {
        if (!isNotNullAndNotEmpty(cs)) {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
