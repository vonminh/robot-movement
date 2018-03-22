package com.tma.solutions.dimension;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link SurfaceTable}.
 *
 * @author vnminh
 */
public class SurfaceTableTest {

    /**
     * Tests {@link SurfaceTable#hasWithinBoundary(Coordinate2D)}.
     */
    @Test
    public void locationWithCoordinateWithinBoundary() {
        SurfaceTable table = new SurfaceTable(5,5);
        Coordinate2D coordinates = new Coordinate2D(5, 0);
        assertTrue(table.hasWithinBoundary(coordinates));
    }

    /**
     * Tests {@link SurfaceTable#hasWithinBoundary(Coordinate2D)}.
     */
    @Test
    public void locationWithPositiveXCoordinateOutOfBoundary() {
        SurfaceTable table = new SurfaceTable(5,5);
        Coordinate2D coordinates = new Coordinate2D(10, 0);
        assertFalse(table.hasWithinBoundary(coordinates));
    }

    /**
     * Tests {@link SurfaceTable#hasWithinBoundary(Coordinate2D)}.
     */
    @Test
    public void locationWithNegativeXCoordinateOutOfBoundary() {
        SurfaceTable table = new SurfaceTable(5,5);
        Coordinate2D coordinates = new Coordinate2D(-10, 0);
        assertFalse(table.hasWithinBoundary(coordinates));
    }

    /**
     * Tests {@link SurfaceTable#hasWithinBoundary(Coordinate2D)}.
     */
    @Test
    public void locationWithPositiveYCoordinateOutOfBoundary() {
        SurfaceTable table = new SurfaceTable(5,5);
        Coordinate2D coordinates = new Coordinate2D(0, 10);
        assertFalse(table.hasWithinBoundary(coordinates));
    }

    /**
     * Tests {@link SurfaceTable#hasWithinBoundary(Coordinate2D)}.
     */
    @Test
    public void locationWithNegativeYCoordinateOutOfBoundary() {
        SurfaceTable table = new SurfaceTable(5,5);
        Coordinate2D coordinates = new Coordinate2D(0, -10);
        assertFalse(table.hasWithinBoundary(coordinates));
    }

}