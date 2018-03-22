package com.tma.solutions.dimension;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests {@link CardinalDirectionEnum}.
 *
 * @author vnminh
 */
public class CardinalDirectionEnumTest {

    /**
     * Test {@link CardinalDirectionEnum#fromDescription(String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testGetEnumfromDescriptionWithIncorrectArgument() {
        CardinalDirectionEnum.fromDescription("ABC");
    }

    /**
     * Test {@link CardinalDirectionEnum#fromDescription(String)}.
     */
    @Test
    public void testGetEnumfromDescription() {
        assertEquals(CardinalDirectionEnum.E, CardinalDirectionEnum.fromDescription("EAST"));
        assertEquals(CardinalDirectionEnum.W, CardinalDirectionEnum.fromDescription("WEST"));
        assertEquals(CardinalDirectionEnum.S, CardinalDirectionEnum.fromDescription("SOUTH"));
        assertEquals(CardinalDirectionEnum.N, CardinalDirectionEnum.fromDescription("NORTH"));
    }
}