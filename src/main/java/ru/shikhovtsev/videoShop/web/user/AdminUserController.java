package ru.shikhovtsev.videoShop.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.to.UserTo;
import ru.shikhovtsev.videoShop.util.UserUtil;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController extends AbstractUserController {

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", super.getAll());
        return "users";
    }

    @Override
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(UserTo userTo) {
        if (userTo.isNew()) {
            super.create(UserUtil.createNewFromTo(userTo));
        } else {
            super.update(userTo, userTo.getId());
        }
    }

    @Override
    @PostMapping(value = "/{id}")
    public void enable(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        super.enable(id, enabled);
    }
}
