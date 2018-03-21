package com.tma.solutions.utils;

public final class StringUtils {

    /**
     * Cannot instantiate.
     */
    private StringUtils() {}

    public static boolean isNotNullOrEmpty(String str) {
        return str != null && !str.isEmpty();
    }
}
