package com.example.cargo_svc.common.enums;

public enum FlightStatusEnum {
    NOT_YET_DEPARTED("Not_yet_departed"),
    DEPARTED("Departed"),
    ARRIVED("Arrived"),
    CANCELLED("Cancelled");

    private final String displayName;

    FlightStatusEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
