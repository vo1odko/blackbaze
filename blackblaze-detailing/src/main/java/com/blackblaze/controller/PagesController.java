package com.blackblaze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping(value = {"", "/"})
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/#services")
    public String getAdminServicesPage() {
        return "admin/services";
    }

    @GetMapping("/#contacts")
    public String getAdminContactsPage() {
        //var result = service.getData();
        //m.setData(result);
        return "admin/contacts";
    }

    @GetMapping("/services/coating")
    public String getTestPage() {
        return "admin/contacts";
    }
}
