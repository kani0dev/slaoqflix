package com.movieFlix.Repository;

import com.movieFlix.Entity.Category;
import com.movieFlix.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositorie extends JpaRepository<Movie , Long > {
    List<Movie> findMovieByCategoriesIn(List<Category> categories);
}
