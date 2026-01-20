package com.movieFlix.Mapper;

import com.movieFlix.Contoller.Request.StreamingRequest;
import com.movieFlix.Contoller.Response.StreamingResponse;
import com.movieFlix.Entity.Streming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streming toEntity(StreamingRequest request){
        return Streming.builder()
                .name(request.name())
                .build();
    }
    public static StreamingResponse toResponse(Streming streming){
        return StreamingResponse.builder()
                .id(streming.getId())
                .name(streming.getName())
                .build();
    }
}
