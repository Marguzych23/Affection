package ru.itis.affection.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.itis.affection.models.User;
import ru.itis.affection.services.UserService;

@Component
public class StringToUserConverter implements Converter<String, User> {

    private final UserService userService;

    @Autowired
    public StringToUserConverter(UserService userService) {
        this.userService = userService;
    }


    @Override
    public User convert(String s) {

        if (s.isEmpty()) {
            return null;
        }

        return this.userService.getUser(Long.parseLong(s));
    }
}

