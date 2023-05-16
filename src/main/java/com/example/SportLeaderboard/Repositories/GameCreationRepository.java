package com.example.SportLeaderboard.Repositories;

import com.example.SportLeaderboard.Module.GameCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameCreationRepository extends JpaRepository<GameCreation,Integer> {


    @Query(value = "SELECT id from game_creation WHERE player_team_id = :playerTeamId", nativeQuery = true)
    Integer getIdByPlayerTemId(@Param("playerTeamId") Integer teamId);
}
