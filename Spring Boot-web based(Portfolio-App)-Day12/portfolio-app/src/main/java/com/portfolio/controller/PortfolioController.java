package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String home() {
        return "about";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/education")
    public String education() {
        return "education";
    }

    @GetMapping("/skills")
    public String skills() {
        return "skills";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}