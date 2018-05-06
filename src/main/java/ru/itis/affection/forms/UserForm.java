package ru.itis.affection.forms;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class UserForm {

    private String login;

    private String email;

    private String password;

    private String repeatPassword;

    private Date birthday;

    private Boolean sex;
}
