package com.test.demo.setting;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@MapperConfig(nullValueMappingStrategy = RETURN_DEFAULT,
		nullValueCheckStrategy = ALWAYS,
		nullValuePropertyMappingStrategy = IGNORE,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		componentModel = "spring")
public interface DefaultMapper {
}
