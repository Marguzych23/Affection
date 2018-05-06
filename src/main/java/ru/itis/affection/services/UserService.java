package ru.itis.affection.services;

import org.springframework.stereotype.Service;
import ru.itis.affection.models.User;

import java.util.List;

@Service
public interface UserService {

    void delete(User user);

    User register(User user);

    User signIn(User user);

    void editUserData(User user);

    User getUser(Long id);

    List<User> getAll();
}
