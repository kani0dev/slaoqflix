package com.movieFlix.Contoller.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(long id, String name,String descricao) {
}
