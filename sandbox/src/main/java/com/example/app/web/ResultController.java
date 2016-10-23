package com.example.app.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class ResultController
{
    @RequestMapping({ "/result" })
    public String result(Model model)
    {
        model.addAttribute("result", "success");

        return "result";
    }
}
