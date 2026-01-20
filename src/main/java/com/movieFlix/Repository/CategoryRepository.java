package com.movieFlix.Repository;

import com.movieFlix.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{}
