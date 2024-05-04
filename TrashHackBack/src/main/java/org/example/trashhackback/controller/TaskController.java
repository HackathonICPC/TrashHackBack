package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
//import org.example.trashhackback.controller.dto.UserDto;
import org.example.trashhackback.controller.request.TaskRequest;
import org.example.trashhackback.controller.request.TokenRequest;
import org.example.trashhackback.controller.response.ListTaskResponse;
import org.example.trashhackback.controller.response.MapTaskResponse;
import org.example.trashhackback.controller.response.TaskResponse;
import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.service.JwtService;
import org.example.trashhackback.service.TaskService;
import org.example.trashhackback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        if (id == -1) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<ListTaskResponse> list = taskService.getListTasks();
        return ResponseEntity.ok(list);
    }

    @PermitAll
    @PostMapping("/new")
    public ResponseEntity<?> setTaskService(@RequestBody TaskRequest taskRequest) {
        TaskDao taskDao = new TaskDao();
        Long id = jwtService.extractId(taskRequest.token());
        if (id == -1) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        System.out.println(id);
        System.out.println("!!!!!!!!!!!" + userService.findById(id));

        taskDao.setCreator(userService.findById(id).get());
        taskDao.setExperience(taskRequest.experience());
        taskDao.setTitle(taskRequest.title());
        taskDao.setDescription(taskRequest.description());
        taskDao.setLat(taskRequest.lat());
        taskDao.setLon(taskRequest.lon());
        taskDao.setPreviewImg(0L);


       boolean result = taskService.addTask(taskDao);
        if (result) {
            return new ResponseEntity<>(taskRequest, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PermitAll
    @PostMapping("/task")
    public ResponseEntity<?> mainTaskInfo(@RequestBody Long taskID)
    {
        TaskDao task = taskService.getTask(taskID);
        TaskResponse taskResponse = new TaskResponse(task.getId(), task.getTitle(), task.getPreviewImg(), task.getDescription(), task.getIsStarted());

        return new ResponseEntity<>(taskResponse, HttpStatus.OK);
    }

    @PermitAll
    @PostMapping("/map")
    public ResponseEntity<?> tasksForMap(@RequestBody TokenRequest token)
    {
        Long id = jwtService.extractId(token.token());
        if (id == -1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<MapTaskResponse> list = taskService.getMapTasks();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}