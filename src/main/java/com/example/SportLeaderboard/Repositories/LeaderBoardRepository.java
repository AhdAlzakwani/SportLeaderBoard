package com.example.SportLeaderboard.Repositories;

import com.example.SportLeaderboard.Module.LeaderBoard;
import com.example.SportLeaderboard.Module.Standing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderBoardRepository extends JpaRepository<LeaderBoard,Integer> {

    @Query(value="Select * from leader_board  where standing_id = :standing_id", nativeQuery = true)
    List<LeaderBoard> getAllLeaderBoardByStandingId(@Param("standing_id") Integer standingId);
}
