package org.example.trashhackback.controller;


import jakarta.annotation.security.PermitAll;
import org.example.trashhackback.controller.request.TokenRequest;
import org.example.trashhackback.entity.TaskDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @PermitAll
    @PostMapping("/envolve")
    public ResponseEntity<?> envolveToTask(@RequestBody TokenRequest token, Long taskID)
    {
        Long userID = jwtService.extractId(token.token());
        if (userID == -1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user token");

        UserDao user = userService.findById(userID).get();

        if (user.hasTask(taskID))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user already have relation");

        user.addTask(taskService.getTask(taskID));
        userService.save(user);

        return ResponseEntity.ok("task related");
    }

    @PermitAll
    @PostMapping("/start")
    public ResponseEntity<?> startTask(@RequestBody TokenRequest token, Long taskID)
    {
        Long userID = jwtService.extractId(token.token());
        if (userID == -1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user token");

        TaskDao taskDao = taskService.getTask(taskID);
        UserDao userDao = userService.findById(userID).get();

        if (userDao.getExperiencePoints() < taskDao.getExperience() || taskDao.getIsStarted())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid task status");

        taskDao.setIsStarted(true);
        taskDao.setCreator(userDao);
        taskService.save(taskDao);

        return ResponseEntity.ok("tasked changed");
    }
}
