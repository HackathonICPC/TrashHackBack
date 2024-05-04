package org.example.trashhackback.service;

import lombok.RequiredArgsConstructor;
import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.entity.UserTaskDao;
import org.example.trashhackback.repository.UserRepository;
import org.example.trashhackback.repository.UserTaskRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;

    public boolean isRelation(UserDao userDao, TaskDao taskDao) {
        return userTaskRepository.existsByUserIdAndTaskId(userDao.getId(), taskDao.getId());
    }

    public void addRelation(UserDao userDao, TaskDao taskDao)  {
        UserTaskDao userTaskDao = new UserTaskDao();

        userTaskDao.setUser(userDao);
        userTaskDao.setTask(taskDao);

        userTaskRepository.save(userTaskDao);
    }
}
