package com.blackblaze.controller;

import com.blackblaze.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("services", serviceService.getAllServices());
        return "index";
    }
}