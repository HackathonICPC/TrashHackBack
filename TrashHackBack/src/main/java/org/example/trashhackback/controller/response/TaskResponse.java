package org.example.trashhackback.controller.response;

public record TaskResponse(String taskPhoto, String taskTitle, String taskDescription, Boolean taskIsStarted) {
}
