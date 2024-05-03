package org.example.trashhackback.repository;

import org.example.trashhackback.entity.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDao, Long> {

    UserDao findByLogin(String login);

    boolean existsByLogin(String login);
}