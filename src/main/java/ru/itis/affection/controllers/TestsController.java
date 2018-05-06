package ru.itis.affection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.affection.dto.TestDto;
import ru.itis.affection.models.User;
import ru.itis.affection.security.details.UserDetailsImpl;
import ru.itis.affection.services.TestService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestsController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String index(
            @RequestParam(name = "sort", required = false) String sortBy,
            ModelMap modelMap,
            Authentication authentication) {

        UserDetailsImpl details = ((UserDetailsImpl) authentication.getDetails());
        User user = details.getUser();

        List<TestDto> testDtoList = null;
        String testType = null;

        if (sortBy == null || sortBy.isEmpty()) {
            testDtoList = testService.getAll();
        } else if (sortBy.equals("passed")) {
            testType = "passed";
            testDtoList = testService.getAllPassed(user);
        } else if (sortBy.equals("not_passed")) {
            testType = "not_passed";
            testDtoList = testService.getAllNotPassed(user);
        } else if (sortBy.equals("not_started")) {
            testType = "not_started";
            testDtoList = testService.getAllNotStarted(user);
        }

        modelMap.addAttribute("testType", testType);
        modelMap.addAttribute("tests", testDtoList);

        return "tests";
    }
}
