package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.GameCreation;
import com.example.SportLeaderboard.Module.Standing;
import com.example.SportLeaderboard.RequestObject.NewGameCreation;
import com.example.SportLeaderboard.RequestObject.NewStanding;
import com.example.SportLeaderboard.RequestObject.UpdateGames;
import com.example.SportLeaderboard.RequestObject.UpdateStanding;
import com.example.SportLeaderboard.Services.StandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class StandingController {

    @Autowired
    StandingService standingService;

    @RequestMapping(value = "api/registerForStanding", method = RequestMethod.POST)
    public String registerForStanding(@RequestBody NewStanding newStanding) throws ParseException {
        try {
            standingService.registerForStanding(newStanding);
            return " Standing created Successfully ";
        }catch (Exception e){
            return "Standing creation failed";

        }


    }


    @RequestMapping(value = "api/updateStanding", method = RequestMethod.POST)
    public String updateStanding(@RequestBody UpdateStanding updateStanding) {
        try {
            standingService.updateStanding(updateStanding);
            return " Standing updated Successfully ";
        }catch (Exception e){
            return " Standing updated failed";

        }


    }

    @RequestMapping(value = "api/deleteStanding", method = RequestMethod.POST)
    public String deleteStanding(@RequestParam Integer standingId) {
        try {
            standingService.deleteStanding(standingId);
            return " Standing deleted Successfully ";
        }catch (Exception e){
            return "Standing deleted failed";

        }


    }


    @RequestMapping(value = "api/getAllStanding", method = RequestMethod.GET)
    public List<Standing> getAllGames() {

        return standingService.getAllStanding();
    }

    @RequestMapping(value = "api/getStandingById", method = RequestMethod.GET)
    public Standing getStandingById(@RequestParam Integer standingId) {

        return standingService.getStandingById(standingId);


    }
}
