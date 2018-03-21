package com.tma.solutions.dimension;

import java.util.Arrays;

public enum CardinalDirectionEnum {

    N("NORTH"), E("EAST"), S("SOUTH"), W("WEST");

    private final String description;

    CardinalDirectionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @return the Enum representation for the given string.
     *
     * @throws IllegalArgumentException if unknown string.
     */
    public static CardinalDirectionEnum fromDescription(String s) throws IllegalArgumentException {
        return Arrays.stream(CardinalDirectionEnum.values())
                .filter(v -> v.description.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value of " + s));
    }
}
