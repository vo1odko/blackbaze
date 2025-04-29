package com.blackblaze.controller;

import com.blackblaze.service.CaseService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("case")
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService serviceService) {
        this.caseService = serviceService;
    }

    @GetMapping(value = {"", "/"})
    public String getAllCasePage(Model model) {
        model.addAttribute("cases", caseService.getAllCase());
        return "case/index.html";
    }

    @GetMapping(value = {"/{caseId}"})
    public String getCasePageById(@PathVariable(name = "caseId") Long caseId, Model model) {
        model.addAttribute("cases", caseService.getCaseById(caseId));
        return "case/detail.html";
    }
}