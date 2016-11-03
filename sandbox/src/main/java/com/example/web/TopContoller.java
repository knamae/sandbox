package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @EnableAutoConfiguration
public class TopContoller
{
    @ModelAttribute
    public MessageForm setupForm()
    {
        return new MessageForm();
    }

    @RequestMapping(value = { "/", "/top" }, method = RequestMethod.GET)
    public String top(MessageForm messageForm, Model model)
    {
        model.addAttribute("messageForm", messageForm);
        return "top";
    }

    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public String doSendMessage(@Validated MessageForm messageForm, BindingResult result,
            Model model)
    {
        if (result.hasErrors())
        {
            return "top";
        }

        return "redirect:result";
    }
}
