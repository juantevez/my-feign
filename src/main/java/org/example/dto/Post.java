package org.example.dto;

public record Post(Long userId,
                   Long id,
                   String title,
                   String body) {

}
