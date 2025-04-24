package com.blackblaze.controller;

import com.blackblaze.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    private final TestService testService;

    public PagesController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/#services")
    public String getAdminServicesPage() {
        return "admin/services";
    }

    @GetMapping("/#contacts")
    public String getAdminContactsPage(ModelMap model) {
        return "admin/contacts";
    }

    @GetMapping("/services/coating")
    public String getTestPage() {
        return "admin/services";
    }
}