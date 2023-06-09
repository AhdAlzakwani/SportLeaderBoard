package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Module.LeaderBoard;
import com.example.SportLeaderboard.RequestObject.NewLeaderBoard;
import com.example.SportLeaderboard.RequestObject.NewStanding;
import com.example.SportLeaderboard.Services.LeaderBorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController

public class LeaderBoardController {

    @Autowired
    LeaderBorderService leaderBorderService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/registerForLeaderBoard", method = RequestMethod.POST)
    public String registerForStanding(@RequestBody NewLeaderBoard newLeaderBoard) throws ParseException {
        try {
            leaderBorderService.registerForLeaderBoard(newLeaderBoard);
            return " LeaderBoard created Successfully ";
        }catch (Exception e){
            return "LeaderBoard creation failed";

        }


    }

    @RequestMapping(value = "api/getAllLeaderBoard", method = RequestMethod.GET)
    public List<LeaderBoard> getAllLeaderBoard() throws ParseException {

           return leaderBorderService.getAllLeaderBoard();



    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "api/leaderboard", method = RequestMethod.GET)
    public List<String> getLeaderBoardBySportName(@RequestParam String sport) {

        List<String> statement = leaderBorderService.getLeaderBoardBySportName(sport);
        return statement;


    }




}
