package com.blackblaze.service;

import com.blackblaze.dto.TestDto;
import com.blackblaze.mapper.TestMapper;
import com.blackblaze.model.Test;
import com.blackblaze.repository.TestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;
    private final TestMapper mapper;

    public TestService(TestRepository testRepository, TestMapper mapper) {
        this.testRepository = testRepository;
        this.mapper = mapper;
    }

    @Transactional
    public TestDto post(TestDto dto) {
        Test entity = mapper.toEntity(dto);
        Test result = testRepository.save(entity);
        return mapper.toDTO(result);
    }

    public List<TestDto> get() {
        List<Test> set = testRepository.findAll();
        return set.stream().map(mapper::toDTO).toList();
    }

    public TestDto delete(TestDto dto) {
        if (testRepository.existsById(dto.getId())) {
            var e = testRepository.getReferenceById(dto.getId());
            testRepository.deleteById(dto.getId());
            return mapper.toDTO(e);
        }
        return null;
    }

    @Transactional
    public TestDto put(TestDto dto) {
        if (testRepository.existsById(dto.getId())) {
            Test entity = mapper.toEntity(dto);
            Test result = testRepository.save(entity);
            return mapper.toDTO(result);
        } else {
            return null;
        }
    }
}
