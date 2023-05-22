package com.example.SportLeaderboard.ScheduleJob;

import com.example.SportLeaderboard.Module.LeaderBoard;
import com.example.SportLeaderboard.Module.PlayerTeam;
import com.example.SportLeaderboard.Module.Standing;
import com.example.SportLeaderboard.Repositories.PlayerTeamRepository;
import com.example.SportLeaderboard.Repositories.StandingRepository;
import com.example.SportLeaderboard.RequestObject.UpdateStanding;
import com.example.SportLeaderboard.Services.LeaderBorderService;
import com.example.SportLeaderboard.Services.StandingService;
import com.example.SportLeaderboard.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
public class ScheduleCron {

    @Autowired
    SlackClient slackClient;

    @Autowired
    StandingService standingService;

    @Autowired
    LeaderBorderService leaderBorderService;

    @Scheduled(cron = " 0 0 * * * *")
    @RequestMapping(value = "getAllStanding")
    public List<LeaderBoard> getAllStanding() {
        List<LeaderBoard> leaderBoards = leaderBorderService.getAllLeaderBoard();
        for (LeaderBoard stand : leaderBoards) {
            slackClient.sendMessage(String.format("LeaderBoard id:" + stand.getId()));
            slackClient.sendMessage(String.format("Team Name:" + stand.getStanding().getPlayerTeam().getTeamName()));
            slackClient.sendMessage(String.format("Win :" + stand.getWins()));
            slackClient.sendMessage(String.format("Losses:" + stand.getLosses()));
            slackClient.sendMessage(String.format("-----------------------------------"));
        }
        return leaderBoards;
    }








}
