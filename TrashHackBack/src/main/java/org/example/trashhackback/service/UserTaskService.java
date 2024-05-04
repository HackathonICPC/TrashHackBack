/*
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

    public boolean isRelation(Long userID, Long taskID) {
        return userTaskRepository.existsByUser_IdAndTask_Id(userID, taskID);
    }

    public void addRelation(Long userID, Long taskID)  {
        UserTaskDao userTaskDao = new UserTaskDao();

        userTaskDao.setUser(userID);
        userTaskDao.setTask(taskID);

        userTaskRepository.save(userTaskDao);
    }
}
*/
