package org.example.trashhackback.controller.response;

public record TaskResponse(Long taskPhoto, String taskTitle, String taskDescription, Boolean taskIsStarted) {
}
