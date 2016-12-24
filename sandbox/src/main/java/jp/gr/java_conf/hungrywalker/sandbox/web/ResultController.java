package jp.gr.java_conf.hungrywalker.sandbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultController
{
    public static final String PAGE = "/result";
    private static final String HTML = "result";

    @RequestMapping({ ResultController.PAGE })
    public String result(Model model)
    {
        model.addAttribute("result", "success");

        return ResultController.HTML;
    }
}
