package ru.itis.affection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.affection.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User findByLogin(String login);

//    @Modifying
//    @Query(value = "UPDATE users SET user_login = :login, user_email = :email, user_password = :password, " +
//            "user_birthday = :birthday, user_sex = :sex WHERE user_id = :id",
//            nativeQuery = true)
//    void update(User user);


}
