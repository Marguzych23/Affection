package ru.itis.affection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.affection.dto.TestQuestionDto;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.mapper.TestMapper;
import ru.itis.affection.models.User;
import ru.itis.affection.security.details.UserDetailsImpl;
import ru.itis.affection.services.TestService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String getTest(ModelMap modelMap,
            @RequestParam(name = "test-name") String testName,
            @RequestParam(name = "test-teacher") String teacherType,
            @RequestParam(name = "test-friend") String friendType,
            Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
        User user = details.getUser();

        UserTestDetailDto userTestDetailDto = testService.getUserTest(testName, user, teacherType, friendType);
        TestQuestionDto testQuestionDto = testService.getTestQuestionDto(userTestDetailDto);

        modelMap.addAttribute("testQuestion", testQuestionDto);
        details.setUserTestDetailDto(userTestDetailDto);

        return "test";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String doPost(@RequestParam(name = "answer") String answer,
            TestMapper testMapper,
            Authentication authentication
    ) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
        UserTestDetailDto userTestDetailDto = details.getUserTestDetailDto();


        userTestDetailDto = testService.checkUserAnswer(userTestDetailDto, answer.trim());

        details.setUserTestDetailDto(userTestDetailDto);


        TestQuestionDto testQuestionDto = testService.getTestQuestionDto(userTestDetailDto);
        String response = testMapper.getTest(testQuestionDto);

        if (testQuestionDto.getIsEnd()) {
            testService.saveUserTest(userTestDetailDto);
        }

        return response;
    }
}
