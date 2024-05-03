package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
//import org.example.trashhackback.controller.dto.UserDto;
import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.service.TaskService;
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

    @PermitAll
    @GetMapping("/list")
    public ResponseEntity<?> listOfTasks() {
        List<TaskDao> list = taskService.getAllTasks();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}