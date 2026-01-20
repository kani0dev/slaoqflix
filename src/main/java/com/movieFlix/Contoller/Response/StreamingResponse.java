package com.movieFlix.Contoller.Response;

import lombok.Builder;

@Builder
public record StreamingResponse(long id ,String name) {
}
