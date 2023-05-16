package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Services.PlayerTeamService;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class PlayerTeamController {

    @Autowired
    PlayerTeamService playerTeamService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/register", method = RequestMethod.POST)
    public String registerNewPlayerTeam(@RequestBody PlayerTeam playerTeam) {
        try {
            playerTeamService.registerNewPlayerTeam(playerTeam);
            return " playerTeams created Successfully ";
        }catch (Exception e){
            return "playerTeams creation failed";

        }


    }


    @RequestMapping(value = "api/update", method = RequestMethod.POST)
    public String updatePlayerTeam(@RequestBody PlayerTeam playerTeam) {
        try {
            playerTeamService.updatePlayerTeam(playerTeam);
            return " playerTeams updated Successfully ";
        }catch (Exception e){
            return "playerTeams updated failed";

        }


    }

    @RequestMapping(value = "api/delete", method = RequestMethod.POST)
    public String deletePlayerTeam(@RequestParam Integer playerId) {
        try {
            playerTeamService.deletePlayerTeam(playerId);
            return " playerTeams deleted Successfully ";
        }catch (Exception e){
            return "playerTeams deleted failed";

        }


    }

    @RequestMapping(value = "api/getAllPlayer", method = RequestMethod.GET)
    public List<PlayerTeam> getAllPlayer() {

        return playerTeamService.getAllGames();
    }

    @RequestMapping(value = "api/getPlayerById", method = RequestMethod.GET)
    public PlayerTeam getPlayerById(@RequestParam Integer playerId) {

        return playerTeamService.getPlayerById(playerId);


    }


}
