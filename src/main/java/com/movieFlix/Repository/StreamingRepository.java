package com.movieFlix.Repository;

import com.movieFlix.Entity.Streming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streming,Long> {
}
