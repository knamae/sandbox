package jp.gr.java_conf.hungrywalker.sandbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopContoller
{
    public static final String PAGE = "/";
    private static final String HTML = "top";

    @ModelAttribute
    public MessageForm setupForm()
    {
        return new MessageForm();
    }

    @RequestMapping(value = TopContoller.PAGE, method = RequestMethod.GET)
    public String top(MessageForm messageForm, Model model)
    {
        model.addAttribute("messageForm", messageForm);
        return TopContoller.HTML;
    }

    @RequestMapping(value = TopContoller.PAGE, method = RequestMethod.POST)
    public String doSendMessage(@Validated MessageForm messageForm, BindingResult result,
            Model model)
    {
        if (result.hasErrors())
        {
            return TopContoller.HTML;
        }

        return "redirect:" + TopContoller.PAGE;
    }
}
