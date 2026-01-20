package com.movieFlix.Contoller;

import com.movieFlix.Entity.Movie;
import com.movieFlix.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieControler {

    private final MovieService service;
    @GetMapping()
    public List<Movie> getall(){
        return service.findall();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id){
        return service.findByid(id);
    }

    @PostMapping()
    public Movie PostMovie(@RequestBody Movie request){
        return service.creatMovie(request);
    }

    @PutMapping("/{id}")
    public Movie PutMovie(@PathVariable long id , @RequestBody Movie request){
        return service.editMovie(id,request);
    }

    @DeleteMapping("/{id}")
    public void DeletMovie(@PathVariable long id){
        service.deletMovie(id);
    }

    @GetMapping("/search")
    public List<Movie> SearchByCategorie(@RequestParam Long category){
        return  service.findByCategorie(category);
    }
}
