package com.movieFlix.Repository;

import com.movieFlix.Entity.Category;
import com.movieFlix.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepositorie extends JpaRepository<Movie , Long > {
    List<Movie> findMovieByCategories(List<Category> category);
}
