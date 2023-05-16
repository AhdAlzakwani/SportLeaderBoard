package com.example.SportLeaderboard.Services;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Standing;
import com.example.SportLeaderboard.Repositories.GameCreationRepository;
import com.example.SportLeaderboard.Repositories.PlayerTeamRepository;
import com.example.SportLeaderboard.Repositories.StandingRepository;
import com.example.SportLeaderboard.RequestObject.NewGameCreation;
import com.example.SportLeaderboard.RequestObject.NewStanding;
import com.example.SportLeaderboard.RequestObject.UpdateStanding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandingService {


    @Autowired
    StandingRepository standingRepository;

    @Autowired
    PlayerTeamRepository playerTeamRepository;

    @Autowired
    GameCreationRepository gameCreationRepository;

    public void registerForStanding(NewStanding newStanding) {

        Standing standing = new Standing();
        standing.setWins(newStanding.getWins());
        standing.setLosses(newStanding.getLosses());
        Integer teamId = playerTeamRepository.getIdByTeamName(newStanding.getTeamName());
        PlayerTeam playerTeamId = playerTeamRepository.findById(teamId).get();
        standing.setPlayerTeam(playerTeamId);
        Integer game = gameCreationRepository.getIdByPlayerTemId(teamId);
        GameCreation gameId = gameCreationRepository.findById(game).get();
        standing.setGameCreation(gameId);
        standingRepository.save(standing);
    }

    public void updateStanding(UpdateStanding updateStanding) {
        Standing standing = new Standing();
        standing.setId(updateStanding.getId());
        standing.setWins(updateStanding.getWins());
        standing.setLosses(updateStanding.getLosses());
        Integer teamId = playerTeamRepository.getIdByPlayerName(updateStanding.getTeamName());
        PlayerTeam playerTeamId = playerTeamRepository.findById(teamId).get();
        standing.setPlayerTeam(playerTeamId);
        standingRepository.save(standing);

    }

    public void deleteStanding(Integer standingId) {
        Standing standing = standingRepository.findById(standingId).get();
        standing.setIsActive("false");
        standingRepository.save(standing);
    }

    public List<Standing> getAllStanding() {

        return standingRepository.findAll();
    }

    public Standing getStandingById(Integer standingId) {

        return standingRepository.findById(standingId).get();
    }
}
