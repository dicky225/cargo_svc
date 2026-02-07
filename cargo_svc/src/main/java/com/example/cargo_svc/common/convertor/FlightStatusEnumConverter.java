package com.example.cargo_svc.common.convertor;

import com.example.cargo_svc.common.enums.FlightStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class FlightStatusEnumConverter implements AttributeConverter<FlightStatusEnum, String> {
    @Override
    public String convertToDatabaseColumn(FlightStatusEnum status) {
        if (status == null) {
            return null;
        }
        return status.getDisplayName();
    }

    @Override
    public FlightStatusEnum convertToEntityAttribute(String displayName) {
        if (displayName == null) {
            return null;
        }

        return Stream.of(FlightStatusEnum.values())
                .filter(c -> c.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown FlightStatusEnum value: " + displayName));
    }
}
