package com.movieFlix.Repository;

import com.movieFlix.Entity.Streming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streming,Long> {
}
