package com.example.SportLeaderboard.Repositories;

import com.example.SportLeaderboard.Module.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Players, Integer> {
}
