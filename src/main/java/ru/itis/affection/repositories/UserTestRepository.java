package ru.itis.affection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.models.UserTest;

import java.util.List;

@Repository
public interface UserTestRepository extends JpaRepository<UserTest, Long> {

    List<UserTest> getAllLastByUserId(Long id);

    List<UserTestDetailDto> getTestDetailsForAllPassedTestByUserId(Long id);

//    List<UserTest> get

    UserTest save(UserTest userTest);
}
