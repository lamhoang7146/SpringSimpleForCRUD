package com.praticalCRUD.Pratical.CRUD.Components;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        LocalDate date = LocalDate.parse(source);
        return date.atStartOfDay();
    }
}

