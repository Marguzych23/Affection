package ru.itis.affection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.affection.dto.TestQuestionDto;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.mapper.TestMapper;
import ru.itis.affection.models.User;
import ru.itis.affection.services.TestService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String getTest(
            HttpSession httpSession,
            ModelMap modelMap,
            @RequestParam(name = "test-name") String testName,
            @RequestParam(name = "test-teacher") String teacherType,
            @RequestParam(name = "test-friend") String friendType
    ) {

        User user = (User) httpSession.getAttribute("user");

        UserTestDetailDto userTestDetailDto = testService.getUserTest(testName, user, teacherType, friendType);
        TestQuestionDto testQuestionDto = testService.getTestQuestionDto(userTestDetailDto);

        modelMap.addAttribute("testQuestion", testQuestionDto);
        httpSession.setAttribute("userTestDetail", userTestDetailDto);

        return "test";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String doPost(
            HttpSession httpSession,
            @RequestParam(name = "answer") String answer,
            TestMapper testMapper
    ) {
        UserTestDetailDto userTestDetailDto = (UserTestDetailDto) httpSession.getAttribute("userTestDetail");

        userTestDetailDto = testService.checkUserAnswer(userTestDetailDto, answer.trim());

        httpSession.setAttribute("userTestDetail", userTestDetailDto);


        TestQuestionDto testQuestionDto = testService.getTestQuestionDto(userTestDetailDto);
        String response = testMapper.getTest(testQuestionDto);

        if (testQuestionDto.getIsEnd()) {
            testService.saveUserTest(userTestDetailDto);
        }

        return response;
    }
}
