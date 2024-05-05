package org.example.trashhackback.controller.response;

public record MapTaskResponse(Long taskID, String taskTitle,
                              String taskDescription, Double taskX, Double taskY,
                              Long taskExperiencePoints) {
}
