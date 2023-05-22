package com.example.SportLeaderboard.Services;

import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Players;
import com.example.SportLeaderboard.Repositories.PlayerRepository;
import com.example.SportLeaderboard.Repositories.PlayerTeamRepository;
import com.example.SportLeaderboard.RequestObject.NewPlayer;
import com.example.SportLeaderboard.RequestObject.UpdatePlayers;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    PlayerTeamRepository playerTeamRepository;

    public void registerNewPlayer(NewPlayer players) {

        Players player = new Players();
        player.setPlayerName(players.getPlayerName());
        player.setPassword(players.getPassword());
         Integer teamid = playerTeamRepository.getIdByTeamName(players.getTeamName());
        PlayerTeam idTeam = playerTeamRepository.findById(teamid).get();
        player.setPlayerTeam(idTeam);
        playerRepository.save(player);
    }

    public void playerUpdate(UpdatePlayers players) {

        Players player = new Players();
        player.setId(players.getId());
        player.setPlayerName(players.getPlayerName());
        player.setPassword(players.getPassword());
        Integer teamid = playerTeamRepository.getIdByTeamName(players.getTeamName());
        PlayerTeam idTeam = playerTeamRepository.findById(teamid).get();
        player.setPlayerTeam(idTeam);
        playerRepository.save(player);
    }

    public void playerDeleted(Integer id) {

        Players players = playerRepository.findById(id).get();
        players.setIsActive("false");
        playerRepository.save(players);
    }

    public List<Players> getAllPlayers() {

        return playerRepository.findAll();
    }

    public Players getPlayersById(Integer id) {

        return playerRepository.findById(id).get();
    }
}
