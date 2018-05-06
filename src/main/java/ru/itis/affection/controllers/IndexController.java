package ru.itis.affection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;

@Controller
@RequestMapping("/")
public class IndexController {
//
//    @PostMapping("/login")
//    public String login() {
//        return "profile";
//    }
//
//    @GetMapping("/logout")
//    public String logout() {
//        return "welcome";
//    }

    @GetMapping("/home")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userForm", new UserForm());
        modelMap.addAttribute("user", new User());
        return "welcome";
    }

    @PostMapping("/signup")
    public String signUp() {

        return "redirect::/tests";
    }
}
