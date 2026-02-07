package com.example.cargo_svc.common.convertor;

import com.example.cargo_svc.common.enums.AircraftCategoryEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class AircraftCategoryEnumConverter implements AttributeConverter<AircraftCategoryEnum, String> {
    @Override
    public String convertToDatabaseColumn(AircraftCategoryEnum category) {
        if (category == null) {
            return null;
        }
        return category.getDisplayName();
    }

    @Override
    public AircraftCategoryEnum convertToEntityAttribute(String displayName) {
        if (displayName == null) {
            return null;
        }

        return Stream.of(AircraftCategoryEnum.values())
                .filter(c -> c.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown AircraftCategoryEnum value: " + displayName));
    }
}
