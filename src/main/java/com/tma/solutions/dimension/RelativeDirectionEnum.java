package com.tma.solutions.dimension;

public enum RelativeDirectionEnum {

    L("LEFT"), R("RIGHT");

    private final String description;

    RelativeDirectionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
