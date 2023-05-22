package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Players;
import com.example.SportLeaderboard.RequestObject.NewPlayer;
import com.example.SportLeaderboard.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
