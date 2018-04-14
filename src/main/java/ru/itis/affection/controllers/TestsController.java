package ru.itis.affection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.affection.dto.TestDto;
import ru.itis.affection.models.User;
import ru.itis.affection.services.TestService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestsController {

    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(
            HttpSession httpSession,
            @RequestParam(name = "sort") String sortBy,
            ModelMap modelMap) {
        User user = (User) httpSession.getAttribute("user");

        List<TestDto> testDtoList = null;
        String testType = null;

        if (sortBy == null || sortBy.isEmpty()) {
            testDtoList = testService.getAll(user);
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
