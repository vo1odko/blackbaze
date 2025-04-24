package com.blackblaze.mapper;

import com.blackblaze.dto.TestDto;
import com.blackblaze.model.Test;
import org.springframework.stereotype.Component;

import java.util.random.RandomGenerator;

@Component
public class TestMapper {
    private final RandomGenerator generator = RandomGenerator.getDefault();
    public TestDto toDTO(Test entity) {
        TestDto dto = new TestDto();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }

    public Test toEntity(TestDto dto) {
        Test entity = new Test();
        entity.setId(dto.getId());
        entity.setValue(dto.value);
        return entity;
    }
}
