package com.example.SportLeaderboard.Repositories;

import com.example.SportLeaderboard.Module.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderBoardRepository extends JpaRepository<LeaderBoard,Integer> {
}
