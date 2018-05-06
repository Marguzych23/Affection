package ru.itis.affection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.affection.models.Test;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {


//    String FIND_ALL_BY_USER_ID_QUERY_START = "SELECT DISTINCT * FROM test AS t " +
//            "LEFT JOIN (SELECT * FROM user_test WHERE user_id = :user_id";
//    String FIND_ALL_BY_USER_ID_QUERY_END = ") AS ut ON t.test_id = ut.test_id;";


    Test findById(Long id);

    Test findByName(String name);

    @Query(value = "SELECT * FROM test WHERE test.test_popularity > 5",
            nativeQuery = true)
    List<Test> findPopular();

//    @Query(value = "SELECT DISTINCT ON (t.test_name) CASE\n" +
//            "       WHEN (ut.user_test_percent IS NULL)\n" +
//            "         THEN 'Not started'\n" +
//            "       WHEN (ut.user_test_percent < 60)\n" +
//            "         THEN 'Not passed'\n" +
//            "       ELSE 'Passed' END AS status, t.test_name\n" +
//            "FROM test AS t\n" +
//            "  LEFT JOIN (SELECT * FROM user_test WHERE user_id = :id) AS ut ON t.test_id = ut.test_id\n" +
//            "GROUP BY status, t.test_name ORDER BY t.test_name, status DESC;",
//            nativeQuery = true)
//    List<TestDto> findAllWithStatusByUserId(@Param("id") Long id);

    @Query(value = "SELECT DISTINCT * FROM test AS t " +
            "LEFT JOIN (SELECT * FROM user_test WHERE user_id = :user_id) AS ut ON t.test_id = ut.test_id;",
            nativeQuery = true)
    List<Test> findAllByUserId(@Param("user_id") Long userId);

    @Query(value = "SELECT DISTINCT * FROM test AS t " +
            "LEFT JOIN (SELECT * FROM user_test WHERE user_id = :user_id AND user_test_percent ISNULL) AS ut ON t.test_id = ut.test_id;",
            nativeQuery = true)
    List<Test> findAllNotStartedByUserId(@Param("user_id") Long userId);

    @Query(value = "SELECT DISTINCT * FROM test AS t " +
            "LEFT JOIN (SELECT * FROM user_test WHERE user_id = :user_id AND user_test_percent >= :user_test_percent) AS ut ON t.test_id = ut.test_id;",
            nativeQuery = true)
    List<Test> findAllByUserIdAndPercentMoreThan(@Param("user_id") Long userId, @Param("user_test_percent") Integer percent);

    @Query(value = "SELECT DISTINCT * FROM test AS t " +
            "LEFT JOIN (SELECT * FROM user_test WHERE user_id = :user_id AND user_test_percent <= :user_test_percent) AS ut ON t.test_id = ut.test_id;",
            nativeQuery = true)
    List<Test> findAllByUserIdAndPercentLessThan(@Param("user_id") Long userId, @Param("user_test_percent") Integer percent);
}
