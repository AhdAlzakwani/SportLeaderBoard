package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.RequestObject.NewGameCreation;
import com.example.SportLeaderboard.RequestObject.UpdateGames;
import com.example.SportLeaderboard.Services.GameCreationService;
import com.example.SportLeaderboard.Services.PlayerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class GameCreationController {

    @Autowired
    GameCreationService gameCreationService;

    @Autowired
    PlayerTeamService playerTeamService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/registerForNewGame", method = RequestMethod.POST)
    public String registerNewNewGame(@RequestBody NewGameCreation newGameCreation) throws ParseException {
        try {
            gameCreationService.registerNewPlayerTeam(newGameCreation);
            return " NewGame created Successfully ";
        }catch (Exception e){
            return "NewGame creation failed";

        }


    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/updateGames", method = RequestMethod.POST)
    public String updateGames(@RequestBody UpdateGames updateGames) {
        try {
            gameCreationService.updateGames(updateGames);
            return " Games updated Successfully ";
        }catch (Exception e){
            return "Games updated failed";

        }


    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/deleteGames", method = RequestMethod.POST)
    public String deleteGames(@RequestParam Integer gameId) {
        try {
            gameCreationService.deleteGames(gameId);
            return " Games deleted Successfully ";
        }catch (Exception e){
            return "Games deleted failed";

        }


    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/getAllGames", method = RequestMethod.GET)
    public List<GameCreation> getAllGames() {

           return gameCreationService.getAllGames();
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/getGamesById", method = RequestMethod.GET)
    public String getGamesById(@RequestParam Integer gameId) {

        String statement = gameCreationService.getGamesById(gameId);
        return statement;


    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/games", method = RequestMethod.GET)
    public String getGames() {
         String statement = gameCreationService.getGames();
         return statement;
    }




}
