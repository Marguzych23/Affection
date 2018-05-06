package ru.itis.affection.transformers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;

import java.util.function.Function;

@Component
public class UserFormToUserTransformer implements Function<UserForm, User> {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User apply(UserForm userForm) {
        User user = User.builder()
                .birthday(userForm.getBirthday())
                .email(userForm.getEmail())
                .login(userForm.getLogin())
                .sex(userForm.getSex())
                .password(userForm.getPassword())
                .build();
        return user;
    }
}
