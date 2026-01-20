package com.movieFlix.Service;

import com.movieFlix.Contoller.Request.StreamingRequest;
import com.movieFlix.Contoller.Response.StreamingResponse;
import com.movieFlix.Entity.Streming;
import com.movieFlix.Mapper.StreamingMapper;
import com.movieFlix.Repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SteamingService {
    private final StreamingRepository repo;

    public SteamingService(StreamingRepository repo) {
        this.repo = repo;
    }

    public List<Streming> findall() {
        return repo.findAll();
    }

    public Streming findById(long id) {
       Optional<Streming> streming = repo.findById(id);
       if(streming.isPresent()){
           return streming.get();
       }
       return null;
    }

    public StreamingResponse CreateStreming(StreamingRequest request) {
        Streming tosave = StreamingMapper.toEntity(request);
        repo.save(tosave);
        return StreamingMapper.toResponse(tosave);
    }

    public void DeletStreming(long id ) {
        repo.deleteById(id);
    }

    public StreamingResponse alterStreming(long id, StreamingRequest request) {
        Streming byId = findById(id);
        Streming entity = StreamingMapper.toEntity(request);
        entity.setId(byId.getId());
        repo.save(entity);
        return StreamingMapper.toResponse(entity);
    }
}
