package ru.itis.affection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.affection.models.TestDetail;

import java.util.List;

@Repository
public interface TestDetailRepository extends JpaRepository<TestDetail, Long> {

    List<TestDetail> getTestDetailsByTest_id(Long test_id);

}
