package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String login) {
        User user = new User();
        user.setEmail(login);
        user.setPassword("123");
        userRepository.save(user);
        return user;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(new User());
    }
}
