package com.blackblaze.controller;

import com.blackblaze.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final TestService testService;

    public HomeController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = {"", "/", "/index"})
    public String showIndexPage(ModelMap model) {
        model.put("test", testService.get());
        return "index";
    }
}
