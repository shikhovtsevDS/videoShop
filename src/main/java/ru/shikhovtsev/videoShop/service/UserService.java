package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.repository.UserRepository;
import ru.shikhovtsev.videoShop.to.UserTo;

import java.util.List;

import static ru.shikhovtsev.videoShop.util.UserUtil.prepareToSave;
import static ru.shikhovtsev.videoShop.util.UserUtil.updateFromTo;

@Service
public class UserService implements UserDetailsService  {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email);
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(prepareToSave(user, passwordEncoder));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public User get(int id) {
        return repository.findById(id).get();
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        repository.save(prepareToSave(user, passwordEncoder));
    }

    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        repository.save(user);
    }

    public void update(UserTo userTo) {
        Assert.notNull(userTo, "user must not be null");
        User user = updateFromTo(get(userTo.getId()), userTo);
        repository.save(prepareToSave(user, passwordEncoder));
    }
}
