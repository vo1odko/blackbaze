package com.blackblaze.controller;

import com.blackblaze.service.AdviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("advice")
public class AdviceController {
    private final AdviceService adviceService;

    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @GetMapping(value = {"{page}"})
    public String getAdvicePage(@PathVariable(name = "page") String page, Model model) {
        Map<String, String> data = adviceService.getAdviceForPage(page);
        model.addAllAttributes(data);
        return "advice/index-advice";
    }
}