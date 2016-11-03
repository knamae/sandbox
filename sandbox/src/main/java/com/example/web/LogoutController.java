package com.example.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @EnableAutoConfiguration
public class LogoutController
{
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String doLogout(HttpSession session, Model model)
    {
        session.invalidate();
        return "redirect:login";
    }
}
