package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.videoShop.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
