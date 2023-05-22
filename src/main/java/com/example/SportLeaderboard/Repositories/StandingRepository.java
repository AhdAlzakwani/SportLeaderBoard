package com.example.SportLeaderboard.Repositories;

import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandingRepository extends JpaRepository<Standing,Integer> {

    @Query(value = "SELECT id FROM standing WHERE player_team_id =:playersId", nativeQuery = true)
    List<Integer> getIdByPlayerTeamId(@Param("playersId") Integer playersId);


    @Query(value = "select COUNT(id) from standing WHERE wins=1 AND player_team_id = :playerTeamId",nativeQuery = true)
    Integer countWin(@Param("playerTeamId") Integer playerTeamId);

    @Query(value = "select COUNT(id) from standing WHERE losses=1 AND player_team_id = :playerTeamId",nativeQuery = true)
    Integer countLoss(@Param("playerTeamId") Integer playerTeamId);

    @Query(value = "select id from standing WHERE player_team_id = :player_team_id", nativeQuery = true)
    List<Standing> getStandingIdByPlayerTeamId(@Param("player_team_id") Integer player_team_id);

}
