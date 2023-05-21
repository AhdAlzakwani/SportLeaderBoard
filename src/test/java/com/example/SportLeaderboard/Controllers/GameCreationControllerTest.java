package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.RequestObject.NewGameCreation;
import com.example.SportLeaderboard.RequestObject.UpdateGames;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameCreationControllerTest {

    @Autowired
    GameCreationController gameCreationController;

    @Test
    void registerNewNewGame(NewGameCreation newGameCreation) throws ParseException {
        String gameCreation = gameCreationController.registerNewNewGame(newGameCreation);
        assertNotNull(gameCreation);
    }

    @Test
    void updateGames(UpdateGames updateGames) {
        String gameCreation = gameCreationController.updateGames(updateGames);
        assertNotNull(gameCreation);
    }


    @Test
    void getAllGames() {

        List<GameCreation> game = gameCreationController.getAllGames();
        assertNotNull(game);
    }
    @Test
    void getGamesById() {
        String game = gameCreationController.getGamesById(1);
        assertNotNull(game);
        assertNotNull(game);
    }
}