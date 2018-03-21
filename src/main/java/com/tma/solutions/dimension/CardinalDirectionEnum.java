package com.tma.solutions.dimension;

public enum CardinalDirectionEnum {

    N("NORTH"), E("EAST"), S("SOUTH"), W("WEST");

    private final String description;

    CardinalDirectionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
