package ru.itis.affection.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.affection.dto.UserTestDetailDto;
import ru.itis.affection.models.User;

import java.util.Collection;
import java.util.Collections;

@Component
public class UserDetailsImpl implements UserDetails {

    private User user;
    private UserTestDetailDto userTestDetailDto;

    private UserDetailsImpl() {
    }

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        return Collections.singletonList(authority);

    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public User getUser() {
        return this.user;
    }

    public UserTestDetailDto getUserTestDetailDto() {
        return userTestDetailDto;
    }

    public void setUserTestDetailDto(UserTestDetailDto userTestDetailDto) {
        this.userTestDetailDto = userTestDetailDto;
    }
}
