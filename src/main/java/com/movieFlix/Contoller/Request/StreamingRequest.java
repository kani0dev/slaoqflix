package com.movieFlix.Contoller.Request;

import com.movieFlix.Entity.Streming;
import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
}
