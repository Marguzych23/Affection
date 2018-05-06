package ru.itis.affection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;
import ru.itis.affection.security.details.UserDetailsImpl;
import ru.itis.affection.services.UserProfileService;
import ru.itis.affection.services.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {


    private UserService userService;
    private UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService, UserService userService) {
        this.userProfileService = userProfileService;
        this.userService = userService;
    }


    @GetMapping
    public String doGet(ModelMap modelMap,
            Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();

        User user = details.getUser();

//
//        if (req.getParameter("details") != null) {
//            req.setAttribute("userTestDetails", userProfileService.getUserTestDetails(user.getId()));
//        }

        modelMap.addAttribute("userTests", userProfileService.getLastUserTests(user.getId()));
        modelMap.addAttribute("userProfile", userService.getUser(user.getId()));

        return "profile";
    }

    @PostMapping
    @ResponseBody
    public String getDetails(
            Authentication authentication
    ) {
//        todo
        UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
        User user = details.getUser();
        return userProfileService.getUserTestDetails(user.getId()).toString();
    }

    @PostMapping("/edit")
    public String editUser(Authentication authentication, @Valid @ModelAttribute(name = "userForm") UserForm userForm,
                           BindingResult result) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
        User user = details.getUser();

        String passwordRepeat = userForm.getRepeatPassword();

        User form = User.builder()
                .id(user.getId())
                .login(userForm.getLogin())
                .password(userForm.getPassword())
                .build();
//       todo
//        if (result.hasErrors()) {
//            form = createNewUser(user, form);
//
//            userService.editUserData(form);
//
//            user = userService.getUser(form.getId());
//
//            req.getSession().setAttribute("user", user);
//            resp.sendRedirect(req.getContextPath() + "/profile");
//        } else {
//            req.setAttribute("editUserErrors", errors);
//            req.getRequestDispatcher(FilePath.PROFILE_PAGE).forward(req, resp);
//        }
        return "";
    }
}
