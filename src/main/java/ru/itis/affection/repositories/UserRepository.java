package ru.itis.affection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.affection.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    List<User> findAll();

    @Query(value = "SELECT * FROM users AS u WHERE u.user_id = :id",
            nativeQuery = true)
    User findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM users AS u WHERE u.user_login = :user_login",
            nativeQuery = true)
    User findByLogin(@Param("user_login") String login);

    void delete(Long id);

    @Modifying
    @Query(value = "UPDATE users SET user_login = :login, user_email = :email, user_password = :password, " +
            "user_birthday = :birthday, user_sex = :sex WHERE user_id = :id",
            nativeQuery = true)
    void update(User user);


}
