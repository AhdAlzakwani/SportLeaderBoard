package com.example.SportLeaderboard.Services;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Repositories.PlayerTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerTeamService {

    @Autowired
    PlayerTeamRepository playerTeamRepository;

    public void registerNewPlayerTeam(PlayerTeam playerTeamInfo) {
        PlayerTeam playerTeams = new PlayerTeam();
        playerTeams.setTeamName(playerTeamInfo.getTeamName());
        playerTeams.setSport(playerTeamInfo.getSport());
        playerTeams.setIsActive("True");
        playerTeamRepository.save(playerTeams);
    }


    public void updatePlayerTeam(PlayerTeam playerTeamInfo) {

        PlayerTeam playerTeams = new PlayerTeam();
        playerTeams.setId(playerTeamInfo.getId());
        playerTeams.setTeamName(playerTeamInfo.getTeamName());
        playerTeams.setSport(playerTeamInfo.getSport());
        playerTeams.setIsActive(playerTeamInfo.getIsActive());
        playerTeamRepository.save(playerTeams);


    }

    public void deletePlayerTeam(Integer playerId) {
        PlayerTeam playerTeam = playerTeamRepository.findById(playerId).get();
        playerTeam.setIsActive("false");
        playerTeamRepository.save(playerTeam);
    }

    public List<PlayerTeam> getAllGames() {
        return playerTeamRepository.findAll();
    }

    public PlayerTeam getPlayerById(Integer playerId) {

        return playerTeamRepository.findById(playerId).get();
    }
}
