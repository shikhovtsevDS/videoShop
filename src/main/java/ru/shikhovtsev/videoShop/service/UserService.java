package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email);
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
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
}