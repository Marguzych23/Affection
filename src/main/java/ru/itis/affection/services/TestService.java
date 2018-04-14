package ru.itis.affection.services;

import org.springframework.stereotype.Service;
import ru.itis.affection.dto.TestDto;
import ru.itis.affection.dto.TestQuestionDto;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.models.User;

import java.util.List;

@Service
public interface TestService {

    TestQuestionDto getTestQuestionDto(UserTestDetailDto userTestDetailDto);

    UserTestDetailDto getUserTest(String testName, User user, String friendType, String teacherType);

    List<TestDto> getPopular();

    UserTestDetailDto checkUserAnswer(UserTestDetailDto userTestDetailDto, String userAnswer);

    boolean saveUserTest(UserTestDetailDto userTestDetailDto);

    TestDto getTest(String name);

    List<TestDto> getAll(User user);

    List<TestDto> getAllPassed(User user);

    List<TestDto> getAllNotPassed(User user);

    List<TestDto> getAllNotStarted(User user);
}
