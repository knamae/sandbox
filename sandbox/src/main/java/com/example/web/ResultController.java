package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @EnableAutoConfiguration
public class ResultController
{
    @RequestMapping({ "/result" })
    public String result(Model model)
    {
        model.addAttribute("result", "success");

        return "result";
    }
}