package com.blackblaze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"", "/", "/index"})
    public String showIndexPage(ModelMap model) {
        return "index";
    }
}
