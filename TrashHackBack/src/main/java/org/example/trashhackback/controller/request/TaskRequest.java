package org.example.trashhackback.controller.request;

import org.springframework.core.codec.StringDecoder;

public record TaskRequest(String token, Long taskPhoto, String taskTitle, String taskDescription,
                          Long taskExperiencePoints, Double taskX, Double taskY) {

}
