package com.tma.solutions.dimension;

public class SurfaceTable {

    private Coordinate2D topRight;
    private Coordinate2D bottomLeft = new Coordinate2D(0, 0);

    public SurfaceTable(int topRightXVal, int topRightYVal) {
        this.topRight = new Coordinate2D(topRightXVal, topRightYVal);
    }

    public boolean hasWithinBoundary(final Coordinate2D coordinates) {
        return this.bottomLeft.hasOutOfBoundary(coordinates) && this.topRight.hasWithinBoundary(coordinates);
    }
}
