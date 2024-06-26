package org.example.trashhackback.service;

import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public Long authenticate(String login, String password) {
        UserDao user = userRepository.findByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            return -1L;
        }
        return user.getId();
    }

    public Long register(String login, String password) {
        if (userRepository.existsByLogin(login)) {
            return -1L; // Пользователь с таким логином уже существует
        }

        UserDao newUser = new UserDao();
        newUser.setLogin(login);
        newUser.setPassword(password);

        return userRepository.save(newUser).getId();
    }
}
