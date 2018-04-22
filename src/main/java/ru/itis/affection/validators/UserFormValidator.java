package ru.itis.affection.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itis.affection.forms.UserForm;
import ru.itis.affection.models.User;
import ru.itis.affection.repositories.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserFormValidator implements Validator {

    private final UserRepository userRepository;

    private String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Autowired
    public UserFormValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.getName().equals(UserForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserForm form = (UserForm) target;

        User existedUser = this.userRepository.findByLogin(form.getLogin());

        if (existedUser != null) {
            errors.reject("bad.login", "Данный логин занят");
        }

        Pattern pattern = Pattern.compile(this.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(form.getEmail());

        if (!matcher.matches()) {
            errors.reject("bad.email", "Введите правильно адрес электронной почты");
        }

    }
}
