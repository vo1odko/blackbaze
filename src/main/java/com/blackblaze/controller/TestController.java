package com.blackblaze.controller;

import com.blackblaze.dto.TestDto;
import com.blackblaze.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    public final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping()
    public List<TestDto> getTest() {
        return testService.get();
    }

    @PostMapping()
    public TestDto addTest(@RequestBody TestDto dto) {
        return testService.post(dto);
    }

    @PutMapping()
    public TestDto changeTest(@RequestBody TestDto dto) {
        return testService.put(dto);
    }

    @DeleteMapping()
    public TestDto deleteTest(@RequestBody TestDto dto) {
        return testService.delete(dto);
    }
}
