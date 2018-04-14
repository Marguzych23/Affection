package ru.itis.affection.forms;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Builder
@Component
public class UserForm {

    private String login;

    private String email;

    private String password;

    private String repeatPassword;

    private Date birthday;

    private Boolean sex;
}
