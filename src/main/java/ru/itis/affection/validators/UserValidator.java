package ru.itis.affection.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.itis.affection.models.User;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        User user = (User)obj;
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
    }

}
