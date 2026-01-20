package com.movieFlix.Contoller;

import com.movieFlix.Contoller.Request.StreamingRequest;
import com.movieFlix.Contoller.Response.StreamingResponse;
import com.movieFlix.Entity.Streming;
import com.movieFlix.Mapper.StreamingMapper;
import com.movieFlix.Service.SteamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("streaming")
@RequiredArgsConstructor
public class StreamingController {


    private final SteamingService service;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> findAll(){
        List<Streming> stremings = service.findall();
        return  ResponseEntity.ok(stremings.stream()
                .map(StreamingMapper::toResponse)
                .toList()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable long id){
        Streming streming = service.findById(id);
        return  ResponseEntity.ok(StreamingMapper.toResponse(streming));
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> regristreStreming(@RequestBody StreamingRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.CreateStreming(request));
    }

    @DeleteMapping("/{id}")
    public void  deletStreming(@PathVariable long id ){
        service.DeletStreming(id);
    }

    @PutMapping("/{id}")
    public StreamingResponse editStreaming(@PathVariable long id, @RequestBody StreamingRequest request){
        return service.alterStreming(id,request);
    }
}
