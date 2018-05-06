package ru.itis.affection.transformers;

import org.springframework.stereotype.Component;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;

import java.util.function.Function;

@Component
public class UserFormToUserTransformer implements Function<UserForm, User> {

    @Override
    public User apply(UserForm userForm) {
        return User.builder()
                .birthday(userForm.getBirthday())
                .email(userForm.getEmail())
                .login(userForm.getLogin())
                .sex(userForm.getSex())
                .password(userForm.getPassword())
                .build();
    }
}
