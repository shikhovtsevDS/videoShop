package ru.shikhovtsev.videoShop.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.service.UserService;
import ru.shikhovtsev.videoShop.to.UserTo;

import static ru.shikhovtsev.videoShop.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected UserService service;

    protected User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    protected void update(UserTo userTo, int id) {
        log.info("update {} with id={}", userTo, id);
        service.update(userTo);
    }
}