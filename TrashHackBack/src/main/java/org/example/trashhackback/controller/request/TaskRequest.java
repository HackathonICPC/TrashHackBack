package org.example.trashhackback.controller.request;

import org.springframework.core.codec.StringDecoder;

public record TaskRequest(String token, String title, String description, Long experience) {

}
