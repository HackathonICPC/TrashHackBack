package org.example.trashhackback.service;


import org.example.trashhackback.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskSevice {

    @Autowired
    private TaskRepository taskRepository;

}
