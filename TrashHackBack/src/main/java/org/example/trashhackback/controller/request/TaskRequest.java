package org.example.trashhackback.controller.request;

import org.springframework.core.codec.StringDecoder;

//ADD IMGPREVIEW
public record TaskRequest(String token, String title, String description, Long experience, Double lat, Double lon) {

}
