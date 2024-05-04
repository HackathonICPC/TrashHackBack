package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
//import org.example.trashhackback.controller.dto.UserDto;
import org.example.trashhackback.controller.request.TaskRequest;
import org.example.trashhackback.entity.TaskDao;
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
    @GetMapping("/list")
    public ResponseEntity<?> listOfTasks() {
        List<TaskDao> list = taskService.getAllTasks();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PermitAll
    @PostMapping("/new")
    public ResponseEntity<?> setTaskService(@RequestBody TaskRequest taskRequest) {
        TaskDao taskDao = new TaskDao();
        taskDao.setCreator(
                userService.findById(jwtService.extractId(taskRequest.token())).get()
        );




//        boolean result = taskService.addTask(;
        boolean result = true;
        if (result) {
            return new ResponseEntity<>(taskRequest, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}