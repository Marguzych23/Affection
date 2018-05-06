package ru.itis.affection.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.models.UserTest;
import ru.itis.affection.repositories.UserTestRepository;
import ru.itis.affection.services.UserProfileService;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserTestRepository userTestRepository;

    public UserProfileServiceImpl(UserTestRepository userTestRepository) {
        this.userTestRepository = userTestRepository;
    }

    public List<UserTest> getLastUserTests(Long userId) {
        return userTestRepository.getAllLastByUserId(userId);
    }

    public List<UserTestDetailDto> getUserTestDetails(Long userId) {
//        return userTestRepository.getTestDetailsForAllPassedTestByUserId(userId);
        return null;
    }
}