package jp.gr.java_conf.hungrywalker.sandbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    public static final String PAGE = "/login";
    private static final String HTML = "login";

    @RequestMapping(value = { LoginController.PAGE })
    public String login()
    {
        return LoginController.HTML;
    }
}
