package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Players;
import com.example.SportLeaderboard.RequestObject.NewPlayer;
import com.example.SportLeaderboard.RequestObject.UpdatePlayers;
import com.example.SportLeaderboard.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/playerRegister", method = RequestMethod.POST)
    public String registerNewPlayer(@RequestBody NewPlayer players) {
        try {
            playerService.registerNewPlayer(players);
            return " playerTeams created Successfully ";
        }catch (Exception e){
            return "playerTeams creation failed";

        }


    }

    @RequestMapping(value = "api/playerUpdate", method = RequestMethod.POST)
    public String playerUpdate(@RequestBody UpdatePlayers players) {
        try {
            playerService.playerUpdate(players);
            return " player Update Successfully ";
        }catch (Exception e){
            return "player Update failed";

        }


    }

    @RequestMapping(value = "api/playerDeleted", method = RequestMethod.POST)
    public String playerDeleted(@RequestParam Integer id) {
        try {
            playerService.playerDeleted(id);
            return " player Deleted Successfully ";
        }catch (Exception e){
            return "player Deleted failed";

        }


    }


}
