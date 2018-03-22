package com.tma.solutions.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link StringUtils}.
 *
 * @author vnminh
 */
public class StringUtilsTest {

    /**
     * Tests {@link StringUtilsTest#testWithNullAndEmptyString()}.
     */
    @Test
    public void testWithNullAndEmptyString() {

        String emptyString = "";
        String nullString = null;

        assertFalse(StringUtils.isNotNullAndNotEmpty(emptyString));
        assertFalse(StringUtils.isNotNullAndNotEmpty(nullString));
    }

    /**
     * Tests {@link StringUtilsTest#testIsNumericMethod()}.
     */
    @Test
    public void testIsNumericMethod() {

        String num = "123";
        String emptyString = "";
        String nullString = null;
        String nonNum0 = "abc";
        String nonNum1 = "a123";
        String nonNum2 = "12ab";

        assertTrue(StringUtils.isNumeric(num));
        assertFalse(StringUtils.isNumeric(emptyString));
        assertFalse(StringUtils.isNumeric(nullString));
        assertFalse(StringUtils.isNumeric(nonNum0));
        assertFalse(StringUtils.isNumeric(nonNum1));
        assertFalse(StringUtils.isNumeric(nonNum2));
    }
}