package org.example.trashhackback.controller.response;

public record TaskResponse(Long id, String title, Long preview, String description, Boolean isStarted, Boolean isRelated) {
}
