package com.example.SportLeaderboard.Repositories;

import com.example.SportLeaderboard.Module.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeam,Integer> {

    @Query(value = "SELECT id FROM player_team WHERE user_name = :payerName", nativeQuery = true)
    Integer getIdByPlayerName(@Param("payerName") String payerName);

    @Query(value = "SELECT id FROM player_team WHERE team_name = :teamName", nativeQuery = true)
    Integer getIdByTeamName(@Param("teamName") String teamName);

    @Query(value = "SELECT * FROM player_team  WHERE sport = :sport", nativeQuery = true)
    List<PlayerTeam> getALLBySportName(@Param("sport") String sport);



//    @Query(value = "SELECT id FROM player_team WHERE sport = :sport", nativeQuery = true)
//    List<Integer> getIdBySportName(@Param("sport") Integer sportName);
}
