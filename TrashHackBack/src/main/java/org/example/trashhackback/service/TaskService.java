package org.example.trashhackback.service;


import org.example.trashhackback.controller.response.ListTaskResponse;
import org.example.trashhackback.controller.response.MapTaskResponse;
import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ImageService imageService;

    public void save(TaskDao taskDao) { taskRepository.save(taskDao); }

    public boolean addTask(TaskDao task) {
        if (taskRepository.findByTitle(task.getTitle()) == null) {
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    public List<TaskDao> getAllTasks() { return taskRepository.findAll(); }

    public TaskDao getTask(Long id) { return taskRepository.findById(id).get();    }

    public List<ListTaskResponse> getListTasks()
    {
        List<TaskDao> tasks = getAllTasks();

        List<ListTaskResponse> list = new ArrayList<ListTaskResponse>();

        for(TaskDao x : tasks)
        {
            ListTaskResponse now = new ListTaskResponse(x.getId(), x.getPhotoID(), x.getTitle());
            list.add(now);
        }
        return list;
    }

    public List<MapTaskResponse> getMapTasks()
    {
        List<TaskDao> tasks = (this).getAllTasks();

        List<MapTaskResponse> list = new ArrayList<MapTaskResponse>();

        for(TaskDao x : tasks)
        {
            MapTaskResponse now = new MapTaskResponse(x.getId(), x.getTitle(), x.getDescription(), x.getX(), x.getY(), x.getExperience());
            list.add(now);
        }
        return list;
    }

    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }
}
