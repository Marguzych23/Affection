package ru.itis.affection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;
import ru.itis.affection.services.UserService;
import ru.itis.affection.services.impl.MailService;
import ru.itis.affection.transformers.UserFormToUserTransformer;

import javax.validation.Valid;

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
    private UserService userService;
    private MailService mailService;
    private UserFormToUserTransformer transformer;

    @Autowired
    public IndexController(UserService userService, MailService mailService, UserFormToUserTransformer transformer) {
        this.userService = userService;
        this.mailService = mailService;
        this.transformer = transformer;
    }

    @GetMapping("/home")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userForm", new UserForm());
        modelMap.addAttribute("user", new User());
        return "welcome";
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute(name = "userForm") UserForm userForm,
                         BindingResult bindingResult,
                         Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "welcome";
        }
        User user = transformer.apply(userForm);

        if (!userService.getAll().contains(user)) {
            mailService.sendEmail(user);
//            UserDetails details = (UserDetails) authentication.getDetails();

            return "redirect:/tests";
        }
        return "redirect:/tests";
    }


}
