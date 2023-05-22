package com.example.SportLeaderboard.Services;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Repositories.GameCreationRepository;
import com.example.SportLeaderboard.Repositories.PlayerTeamRepository;
import com.example.SportLeaderboard.RequestObject.NewGameCreation;
import com.example.SportLeaderboard.RequestObject.UpdateGames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameCreationService {

    @Autowired
    GameCreationRepository gameCreationRepository;

    @Autowired
    PlayerTeamRepository playerTeamRepository;
    public void registerNewPlayerTeam(NewGameCreation newGameCreation) {
      GameCreation gameCreationInfo = new GameCreation();
        gameCreationInfo.setScore(newGameCreation.getScore());
        Integer playerId = playerTeamRepository.getIdByTeamName(newGameCreation.getTeamName());
        PlayerTeam playerTeam = playerTeamRepository.findById(playerId).get();
        gameCreationInfo.setPlayerTeam(playerTeam);
        gameCreationInfo.setIsActive(newGameCreation.getIsActive());
        gameCreationRepository.save(gameCreationInfo);




    }

    public void updateGames(UpdateGames updateGames) {
        GameCreation gameCreationInfo = new GameCreation();
        gameCreationInfo.setId(updateGames.getId());
        gameCreationInfo.setScore(updateGames.getScore());
        Integer playerId = playerTeamRepository.getIdByPlayerName(updateGames.getPayerName());
        PlayerTeam playerTeam = playerTeamRepository.findById(playerId).get();
        gameCreationInfo.setPlayerTeam(playerTeam);
        gameCreationRepository.save(gameCreationInfo);


    }

    public void deleteGames(Integer gameId) {
        GameCreation gameCreation = gameCreationRepository.findById(gameId).get();
    gameCreation.setIsActive("false");
    gameCreationRepository.save(gameCreation);
    }

    public List<GameCreation> getAllGames() {

        return gameCreationRepository.findAll();
    }

    public List<String> getGames() {
        List<GameCreation> gameCreation = gameCreationRepository.findAll();
        List<String> message = new ArrayList<>();
        for (GameCreation g:gameCreation) {
            PlayerTeam playerTeam = g.getPlayerTeam();
            Integer id = playerTeamRepository.getIdByTeamName(playerTeam.getTeamName());
            Integer score = gameCreationRepository.getScoreByPlayerTeamId(id);
             String messages = "team Name : "+playerTeam.getTeamName() + " , "+
                    "Scope : "+score;
             message.add(messages);
        }
        return message;
    }

    public String getGamesById(Integer gameId) {

        GameCreation gameCreation = gameCreationRepository.findById(gameId).get();

        PlayerTeam playerTeam = gameCreation.getPlayerTeam();
        Integer id = playerTeamRepository.getIdByTeamName(playerTeam.getTeamName());
        Integer score = gameCreationRepository.getScoreByPlayerTeamId(id);
        String gameMessage = "team Name : "+playerTeam.getTeamName() +" "+
                "Score : "+score;

        return gameMessage;
    }
}
