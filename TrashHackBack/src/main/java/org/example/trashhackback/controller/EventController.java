package org.example.trashhackback.controller;


import jakarta.annotation.security.PermitAll;
import org.example.trashhackback.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PermitAll
    @PostMapping("/envolve")
    public ResponseEntity<?> envolveToTask(@RequestBody String token, Long taskID)
    {


        return ResponseEntity.ok("Helloo");
    }

}
