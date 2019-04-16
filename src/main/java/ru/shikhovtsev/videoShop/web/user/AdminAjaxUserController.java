package ru.shikhovtsev.videoShop.web.user;

import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.to.UserTo;
import ru.shikhovtsev.videoShop.util.UserUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxUserController extends AbstractUserController {

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable("id") int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@Valid UserTo userTo) {
        if (userTo.isNew()) {
            super.create(UserUtil.createNewFromTo(userTo, "123"));
        } else {
            super.update(userTo, userTo.getId());
        }
    }

    @PostMapping(value = "/{id}")
    public void enable(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        log.info((enabled ? "enable " : "disable ") + id);
        service.enable(id, enabled);
    }
}
