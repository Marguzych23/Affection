package ru.itis.affection.services;

import org.springframework.stereotype.Service;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.models.UserTest;

import java.util.List;

@Service
public interface UserProfileService {

    List<UserTest> getLastUserTests(Long userId);

    List<UserTestDetailDto> getUserTestDetails(Long userId);
}
