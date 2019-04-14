package ru.shikhovtsev.videoShop.model;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
public enum UserRole implements GrantedAuthority {
    ADMIN,
    USER,
    MODER;

    @Override
    public String getAuthority() {
        return name();
    }
}
