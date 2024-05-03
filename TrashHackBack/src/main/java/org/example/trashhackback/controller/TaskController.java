package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import org.example.trashhackback.controller.dto.UserDto;
import org.example.trashhackback.service.TaskSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    TaskSevice taskSevice;

    @PermitAll
    @GetMapping("/list")
    public ResponseEntity<?> listOfTasks() {

        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}