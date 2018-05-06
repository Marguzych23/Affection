package ru.itis.affection.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.affection.dto.TestDetailDto;
import ru.itis.affection.dto.TestDto;
import ru.itis.affection.dto.TestQuestionDto;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.models.Test;
import ru.itis.affection.models.TestDetail;
import ru.itis.affection.models.User;
import ru.itis.affection.models.UserTest;
import ru.itis.affection.repositories.TestRepository;
import ru.itis.affection.repositories.UserTestRepository;
import ru.itis.affection.services.TestService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final Integer PASSED_TEST_PERCENT = 100;
    private final Integer NOT_PASSED_TEST_PERCENT = 60;

    private TestRepository testRepository;
    private UserTestRepository userTestRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository, UserTestRepository userTestRepository) {
        this.testRepository = testRepository;
        this.userTestRepository = userTestRepository;
    }

    @Override
    public TestQuestionDto getTestQuestionDto(UserTestDetailDto userTestDetailDto) {
        return TestQuestionDto.builder()
                .question(userTestDetailDto.getTestDto().getTestDetailsDto().get(userTestDetailDto.getQuestionNumber()).getQuestion())
                .friendImg(AgentImgFactory.getFriendImg(userTestDetailDto.getFriendType(), userTestDetailDto.getLastAnswerIsRight()))
                .teacherImg(AgentImgFactory.getTeacherImg(userTestDetailDto.getTeacherType(), userTestDetailDto.getLastAnswerIsRight()))
                .isEnd(userTestDetailDto.getQuestionNumber() == userTestDetailDto.getTestDto().getTestDetailsDto().size() + 1)
                .build();
    }

    @Override
    public UserTestDetailDto getUserTest(String testName, User user, String friendType, String teacherType) {
        return UserTestDetailDto.builder()
                .friendType(friendType)
                .teacherType(teacherType)
                .questionNumber(1)
                .rightAnswerNumber(0)
                .testDto(getTest(testName))
                .userId(user.getId())
                .lastAnswerIsRight(false)
                .build();
    }

    @Override
    public List<TestDto> getPopular() {
        List<TestDto> testDtoList = new ArrayList<>();
        for (Test test :
                testRepository.findPopular()) {
            testDtoList.add(TestDto.builder()
                    .name(test.getName())
                    .build());
        }
        return testDtoList;
    }

    @Override
    public UserTestDetailDto checkUserAnswer(UserTestDetailDto userTestDetailDto, String userAnswer) {
//        int rightAnswerCount = userTestDetailDto.getPercent() * userTestDetailDto.getTestDto().getTestDetailsDto().size() + 1;
        userTestDetailDto.setQuestionNumber(userTestDetailDto.getQuestionNumber() + 1);
        if (userTestDetailDto.getTestDto().getTestDetailsDto().get(0).getAnswer().equalsIgnoreCase(userAnswer)) {
//            rightAnswerCount++;
            userTestDetailDto.setRightAnswerNumber(userTestDetailDto.getRightAnswerNumber() + 1);
        }
//        userTestDetailDto.setPercent(rightAnswerCount / userTestDetailDto.getTestDto().getTestDetailsDto().size());
//        if (userTestDetailDto.getQuestionNumber() == userTestDetailDto.getTestDto().getTestDetailsDto().size()) {
//            userTestDetailDto.setTestIsEnd(true);
//        }
        return userTestDetailDto;
    }

    @Override
    public boolean saveUserTest(UserTestDetailDto userTestDetailDto) {

        UserTest userTest = UserTest.builder()
                .user(User.builder().id(userTestDetailDto.getUserId()).build())
                .date(new Date())
                .friendType(userTestDetailDto.getFriendType())
                .teacherType(userTestDetailDto.getTeacherType())
                .percent(userTestDetailDto.getRightAnswerNumber() / userTestDetailDto.getTestDto().getTestDetailsDto().size())
                .build();

        userTestRepository.save(userTest);

        return false;
    }

    @Override
    public TestDto getTest(String name) {
        Test test = testRepository.findByName(name);

        return TestDto.builder()
                .name(test.getName())
                .testDetailsDto(convertTestDetailListToDtoList(test.getTestDetails()))
                .build();
    }

    @Override
    public List<TestDto> getAll(User user) {
        return convertTestListToDtoList(testRepository.findAllByUserId(user.getId()), null);
    }

    @Override
    public List<TestDto> getAllPassed(User user) {
        return convertTestListToDtoList(testRepository.findAllByUserIdAndPercentMoreThan(user.getId(), PASSED_TEST_PERCENT), "Passed");
    }

    @Override
    public List<TestDto> getAllNotPassed(User user) {
        return convertTestListToDtoList(testRepository.findAllByUserIdAndPercentLessThan(user.getId(), NOT_PASSED_TEST_PERCENT), "Not passed");
    }

    @Override
    public List<TestDto> getAllNotStarted(User user) {
        return convertTestListToDtoList(testRepository.findAllNotStartedByUserId(user.getId()), "Not started");
    }

    private List<TestDetailDto> convertTestDetailListToDtoList(List<TestDetail> testDetails) {
        List<TestDetailDto> testDetailsDto = new ArrayList<>();
        for (TestDetail testDetail :
                testDetails) {
            testDetailsDto.add(TestDetailDto.builder()
                    .question(testDetail.getQuestion())
                    .answer(testDetail.getAnswer())
                    .build());
        }
        return testDetailsDto;
    }

    private List<TestDto> convertTestListToDtoList(List<Test> testList, String status) {
        List<TestDto> testDtoList = new ArrayList<>();
        for (Test test:
                testList) {
            testDtoList.add(TestDto.builder()
                    .name(test.getName())
                    .status(status)
                    .build());
        }
        return testDtoList;

    }

}
