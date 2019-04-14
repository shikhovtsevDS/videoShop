package ru.shikhovtsev.videoShop.model;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_MODER;

    @Override
    public String getAuthority() {
        return name();
    }
}
