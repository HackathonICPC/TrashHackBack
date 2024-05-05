package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
//import org.example.trashhackback.controller.dto.UserDto;
import org.example.trashhackback.controller.request.TaskRequest;
import org.example.trashhackback.controller.request.TokenRequest;
import org.example.trashhackback.controller.response.ListTaskResponse;
import org.example.trashhackback.controller.response.MapTaskResponse;
import org.example.trashhackback.controller.response.TaskResponse;
import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.service.JwtService;
import org.example.trashhackback.service.TaskService;
import org.example.trashhackback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @PermitAll
    @PostMapping("/list")
    public ResponseEntity<?> listOfTasks(@RequestBody TokenRequest token) {
        Long id = jwtService.extractId(token.token());
        if (id == -1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        List<ListTaskResponse> list = taskService.getListTasks();
        return ResponseEntity.ok(list);
    }

    @PermitAll
    @PostMapping("/new")
    public ResponseEntity<?> setTaskService(@RequestBody TaskRequest taskRequest) {
        TaskDao taskDao = new TaskDao();
        Long id = jwtService.extractId(taskRequest.token());
        if (id == -1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        UserDao userDao = userService.findById(id).get();

        taskDao.setCreator(userDao);
        taskDao.setExperience(taskRequest.taskExperiencePoints());
        taskDao.setTitle(taskRequest.taskTitle());
        taskDao.setDescription(taskRequest.taskDescription());
        taskDao.setX(taskRequest.taskX());
        taskDao.setY(taskRequest.taskY());
        taskDao.setPhotoID(taskRequest.taskPhoto());

        taskService.addTask(taskDao);

        return ResponseEntity.ok("nice, man");
    }

    @PermitAll
    @PostMapping("/task")
    public ResponseEntity<?> mainTaskInfo(@RequestBody TokenRequest token, Long taskID)
    {
        Long userID = jwtService.extractId(token.token());
        if (userID == -1)
            return new ResponseEntity<>("invalid user token", HttpStatus.BAD_REQUEST);

        UserDao user = userService.findById(userID).get();
        TaskDao task = taskService.getTask(taskID);
        boolean isRelated = user.hasTask(taskID);

        // NADO ISPRAVIT ID -> STRING NA PHOTO URL
        TaskResponse taskResponse = new TaskResponse(task.getPhotoID().toString(), task.getTitle(), task.getDescription(), isRelated);

        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @PermitAll
    @PostMapping("/map")
    public ResponseEntity<?> tasksForMap(@RequestBody TokenRequest token)
    {
        Long userID = jwtService.extractId(token.token());
        if (userID == -1)
            return new ResponseEntity<>("invalid user token", HttpStatus.BAD_REQUEST);

        List<MapTaskResponse> list = taskService.getMapTasks();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}