package com.blackblaze.controller;

import com.blackblaze.model.ServiceEntity;
import com.blackblaze.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("service")
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

    @GetMapping(value = {"{id}", "{id}/"})
    public ResponseEntity<String> getPageDetail(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(id);
    }
}