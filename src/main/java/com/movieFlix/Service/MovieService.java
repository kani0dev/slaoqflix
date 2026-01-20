package com.movieFlix.Service;

import com.movieFlix.Entity.Category;
import com.movieFlix.Entity.Movie;
import com.movieFlix.Repository.MovieRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepositorie repo;

    public MovieService(MovieRepositorie repo) {
        this.repo = repo;
    }

    public List<Movie> findall() {
        return repo.findAll();
    }

    public Movie findByid(long id){
        Optional<Movie> thismovie = repo.findById(id);
        if(thismovie.isPresent()){
            return thismovie.get();
        }
        return null;
    }

    public Movie creatMovie(Movie request){
        return  repo.save(request);
    }

    public void deletMovie(long id){
        repo.deleteById(id);
    }

    public Movie editMovie(long id, Movie request){
        Movie thismovie = findByid(id);
        if(thismovie != null){
            thismovie = request;
            thismovie.setId(id);
        }
        return repo.save(thismovie);
    }

    public List<Movie> findByCategorie(Long id){
        return repo.findMovieByCategories(List.of(Category.builder().id(id).build()));
    }
}
