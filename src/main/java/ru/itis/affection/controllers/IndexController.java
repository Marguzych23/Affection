package ru.itis.affection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/login")
    public String login(ModelMap modelMap, @ModelAttribute("userForm")UserForm loginForm) {
        //loginForm checking TODO
        
        return "profile";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap modelMap) {
        //logout from session TODO
        return "welcome";
    }
}
