package com.example.SportLeaderboard.Services;

import com.example.SportLeaderboard.Module.LeaderBoard;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Standing;
import com.example.SportLeaderboard.Repositories.LeaderBoardRepository;
import com.example.SportLeaderboard.Repositories.PlayerTeamRepository;
import com.example.SportLeaderboard.Repositories.StandingRepository;
import com.example.SportLeaderboard.RequestObject.NewLeaderBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderBorderService {

    @Autowired
    LeaderBoardRepository leaderBoardRepository;

    @Autowired
    PlayerTeamRepository playerTeamRepository;

    @Autowired
    StandingRepository standingRepository;
    public void registerForLeaderBoard(NewLeaderBoard newLeaderBoard) {

        LeaderBoard leaderBoard = new LeaderBoard();

           Integer playerTeamId = playerTeamRepository.getIdByTeamName(newLeaderBoard.getTeamName());
            List<Integer> standing = standingRepository.getIdByPlayerTeamId(playerTeamId);
            Standing standingId = standingRepository.findAllById(standing).get(0);
            leaderBoard.setStanding(standingId);


            Integer wainCal = standingRepository.countWin(playerTeamId);
            Integer lossCal = standingRepository.countLoss(playerTeamId);
            leaderBoard.setWins(wainCal);
            leaderBoard.setLosses(lossCal);


            leaderBoardRepository.save(leaderBoard);







    }
}
