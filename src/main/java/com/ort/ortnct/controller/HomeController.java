package com.ort.ortnct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin(origins = "*")
public class HomeController
{
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

}
