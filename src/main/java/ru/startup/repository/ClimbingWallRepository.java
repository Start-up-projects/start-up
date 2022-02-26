package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.ClimbingWall;

@Repository
public interface ClimbingWallRepository extends JpaRepository<ClimbingWall, Long> {
}