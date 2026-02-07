package com.example.cargo_svc.common.enums;

public enum AircraftCategoryEnum {
    FREIGHTER("Freighter"),
    WIDE_BODY("Wide-Body"),
    NARROW_BODY("Narrow-Body");

    private final String displayName;

    AircraftCategoryEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
