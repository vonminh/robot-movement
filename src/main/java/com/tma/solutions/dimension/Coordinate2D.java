package com.tma.solutions.dimension;

import java.util.Objects;

/**
 * Coordinate in 2D declaration.
 *
 * @author vnminh
 */
public class Coordinate2D {

    private int xVal;
    private int yVal;

    public Coordinate2D(int xVal, int yVal) {
        this.xVal = xVal;
        this.yVal = yVal;
    }

    public boolean hasWithinBoundary(Coordinate2D coordinates) {
        return isXCoordinateWithinBoundary(coordinates.xVal) && isYCoordinateWithinBoundary(coordinates.yVal);
    }

    public boolean hasOutOfBoundary(Coordinate2D coordinates) {
        return isXCoordinateOutsideBoundary(coordinates.xVal) && isYCoordinateOutsideBoundary(coordinates.yVal);
    }

    private boolean isXCoordinateWithinBoundary(int xVal) {
        return xVal <= this.xVal;
    }

    private boolean isYCoordinateWithinBoundary(int yVal) {
        return yVal <= this.yVal;
    }

    private boolean isXCoordinateOutsideBoundary(int xVal) {
        return xVal >= this.xVal;
    }

    private boolean isYCoordinateOutsideBoundary(int yVal) {
        return yVal >= this.yVal;
    }

    public void setxVal(int xVal) {
        this.xVal = xVal;
    }

    public void setyVal(int yVal) {
        this.yVal = yVal;
    }

    public int getxVal() {
        return xVal;
    }

    public int getyVal() {
        return yVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate2D that = (Coordinate2D) o;
        return xVal == that.xVal &&
                yVal == that.yVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xVal, yVal);
    }
}
