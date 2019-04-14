package ru.shikhovtsev.videoShop.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.model.Role;
import ru.shikhovtsev.videoShop.to.UserTo;

public class UserUtil {

    public static User createNewFromTo(UserTo newUser) {
        return new User(null, newUser.getFirstName(), newUser.getMiddleName(), newUser.getLastName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setFirstName(userTo.getFirstName());
        user.setMiddleName(userTo.getMiddleName());
        user.setLastName(userTo.getLastName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }

    public static User prepareToSave(User user, PasswordEncoder passwordEncoder) {
        String password = user.getPassword();
        user.setPassword(StringUtils.isEmpty(password) ? password : passwordEncoder.encode(password));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}