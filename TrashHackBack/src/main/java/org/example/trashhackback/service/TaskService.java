package org.example.trashhackback.service;


import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public boolean addTask(TaskDao task) {
        if (taskRepository.findByTitle(task.getTitle()) == null) {
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    public List<TaskDao> getAllTasks()
    {
        return taskRepository.findAll();
    }

}