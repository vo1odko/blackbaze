package com.blackblaze.controller;

import com.blackblaze.model.ServiceEntity;
import com.blackblaze.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping(value = {"", "/", "/index"})
    public String getIndexPage(Model model) {
        List<ServiceEntity> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        return "index";
    }
}