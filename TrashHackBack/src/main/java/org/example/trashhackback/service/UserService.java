package org.example.trashhackback.service;

import lombok.RequiredArgsConstructor;
import org.example.trashhackback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.trashhackback.entity.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void save(UserDao userDao) {
        userRepository.save(userDao);
    }

    public List<UserDao> get() {
        return userRepository.findAll();
    }
}
