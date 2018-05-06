package ru.itis.affection.services.impl;

import org.springframework.stereotype.Service;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;
import ru.itis.affection.repositories.UserRepository;
import ru.itis.affection.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void delete(User user) {
        userRepository.delete(user.getId());
    }

    public User register(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setLogin(user.getLogin().toLowerCase());
        userRepository.save(user);
        return user;
    }

    public User signIn(User user) {
        User model = userRepository.findByLogin(user.getLogin().toLowerCase());
        if (model != null && model.getPassword().equals(user.getPassword())) {
            return model;
        }
        return null;
    }

    public void editUserData(User user) {
        User model = userRepository.findById(user.getId());
        model.setLogin(user.getLogin().toLowerCase());
        model.setPassword(user.getPassword());
        userRepository.save(model);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(String login) {
        return userRepository.findByLogin(login);
    }

    public UserForm getUserForm(Long id) {
        User user = userRepository.findById(id);
        return UserForm.builder()
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword())
                .birthday(user.getBirthday())
                .sex(user.getSex())
                .build();
    }

}
