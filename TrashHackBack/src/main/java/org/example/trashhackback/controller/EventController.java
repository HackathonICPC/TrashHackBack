package org.example.trashhackback.controller;


import jakarta.annotation.security.PermitAll;
import org.example.trashhackback.controller.request.TokenRequest;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.service.EventService;
import org.example.trashhackback.service.JwtService;
import org.example.trashhackback.service.UserService;
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

    @PermitAll
    @PostMapping("/envolve")
    public ResponseEntity<?> envolveToTask(@RequestBody TokenRequest token, Long taskID)
    {
        Long id = jwtService.extractId(token.token());
        if (id == -1)
            return new ResponseEntity<>("invalid user token", HttpStatus.BAD_REQUEST);

        UserDao userDao = userService.findById(id).get();

        return ResponseEntity.ok("Helloo");
    }

}
