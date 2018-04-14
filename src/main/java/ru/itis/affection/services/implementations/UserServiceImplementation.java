package ru.itis.affection.services.implementations;

import org.springframework.stereotype.Service;
import ru.itis.affection.models.User;
import ru.itis.affection.repositories.UserRepository;
import ru.itis.affection.services.UserService;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
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
        userRepository.update(model);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

}
