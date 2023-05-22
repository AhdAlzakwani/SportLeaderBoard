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

import java.util.ArrayList;
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
            leaderBoard.setIsActive("true");


            leaderBoardRepository.save(leaderBoard);

    }

    public List<LeaderBoard> getAllLeaderBoard() {
        return leaderBoardRepository.findAll();
    }

    public List<String> getLeaderBoardBySportName(String sportName) {
       List<PlayerTeam> playerTeams = playerTeamRepository.getALLBySportName(sportName);
        List<String> leaderList = new ArrayList<>();
        for (PlayerTeam i:playerTeams) {
            Integer id = i.getId();
//            PlayerTeam playerTeamId = playerTeamRepository.findById(id).get();
            List<Standing> standingList = standingRepository.getStandingIdByPlayerTeamId(id);
            for (Standing s:standingList) {
                Integer sId = s.getId();
//                Standing standingId = standingRepository.findById(sId).get();
                List<LeaderBoard> leaderBoards = leaderBoardRepository.getAllLeaderBoardByStandingId(sId);

                for (LeaderBoard stand : leaderBoards) {
                    String message = String.format("LeaderBoard id:" + stand.getId())+
                            String.format("Team Name:" + stand.getStanding().getPlayerTeam().getTeamName())+
                            String.format("Win :" + stand.getWins())+
                            String.format("Losses:" + stand.getLosses());
                    leaderList.add(message);
                }

            }


        }
        return leaderList;
    }
}
