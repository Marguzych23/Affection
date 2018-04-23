package ru.itis.affection.security.security.providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.affection.models.User;
import ru.itis.affection.repositories.UserRepository;

import java.util.Collection;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final Logger logger = LogManager.getLogger(UserAuthenticationProvider.class);

    @Autowired
    public UserAuthenticationProvider(UserRepository userRepository, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        logger.info("Авторизуем пользователя");

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = this.userRepository.findByLogin(username);

        if (user != null) {

            if (!passwordEncoder.matches(password, user.getPassword())) {

                logger.warn("Ищем по временному пародю");

            }

        } else {
            throw new BadCredentialsException("Wrong password or login");
        }

        UserDetails details = this.userDetailsService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
        return new UsernamePasswordAuthenticationToken(details, password, authorities);

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
