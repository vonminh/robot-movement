package com.tma.solutions.utils;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link InputUtils}.
 *
 * @author vnminh
 */
public class InputUtilsTest {

    /**
     * Tests {@link InputUtils#collectInputFromFile(String)}.
     *
     * @throws Exception if any error occurs
     */
    @Test
    public void testInputStringCanBeRead() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testInput_ok.txt").getFile());
        List<String> testFileLines = InputUtils.collectInputFromFile(file.getAbsolutePath());

        String expectedLine1 = "PLACE 1,2,EAST";
        String expectedLine2 = "MOVE";
        String expectedLine3 = "MOVE";
        String expectedLine4 = "LEFT";
        String expectedLine5 = "MOVE";
        String expectedLine6 = "REPORT";

        assertEquals(6, testFileLines.size());
        assertEquals(expectedLine1, testFileLines.get(0));
        assertEquals(expectedLine2, testFileLines.get(1));
        assertEquals(expectedLine3, testFileLines.get(2));
        assertEquals(expectedLine4, testFileLines.get(3));
        assertEquals(expectedLine5, testFileLines.get(4));
        assertEquals(expectedLine6, testFileLines.get(5));
    }

    /**
     * Tests {@link InputUtils#collectInputFromFile(String)}.
     *
     * @throws Exception if any error occurs
     */
    @Test
    public void testInputStringCanBeEmpty() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testInput_emptyLine.txt").getFile());
        List<String> testFileLines = InputUtils.collectInputFromFile(file.getAbsolutePath());

        String expectedLine1 = "PLACE 1,2,EAST";
        String expectedLine2 = "MOVE";
        String expectedLine3 = "MOVE";
        String expectedLine4 = "LEFT";
        String expectedLine5 = "MOVE";
        String expectedLine6 = "REPORT";

        assertEquals(6, testFileLines.size());
        assertEquals(expectedLine1, testFileLines.get(0));
        assertEquals(expectedLine2, testFileLines.get(1));
        assertEquals(expectedLine3, testFileLines.get(2));
        assertEquals(expectedLine4, testFileLines.get(3));
        assertEquals(expectedLine5, testFileLines.get(4));
        assertEquals(expectedLine6, testFileLines.get(5));
    }

    /**
     * Tests {@link InputUtils#collectInputFromFile(String)}.
     *
     * @throws Exception if any error occurs
     */
    @Test
    public void testInputStringAreCaseNonSensitive() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testInput_caseDifferent.txt").getFile());
        List<String> testFileLines = InputUtils.collectInputFromFile(file.getAbsolutePath());

        String expectedLine1 = "PLACE 1,2,EAST";
        String expectedLine2 = "MOVE";
        String expectedLine3 = "MOVE";
        String expectedLine4 = "LEFT";
        String expectedLine5 = "MOVE";
        String expectedLine6 = "REPORT";

        assertEquals(6, testFileLines.size());
        assertEquals(expectedLine1, testFileLines.get(0));
        assertEquals(expectedLine2, testFileLines.get(1));
        assertEquals(expectedLine3, testFileLines.get(2));
        assertEquals(expectedLine4, testFileLines.get(3));
        assertEquals(expectedLine5, testFileLines.get(4));
        assertEquals(expectedLine6, testFileLines.get(5));
    }
}
