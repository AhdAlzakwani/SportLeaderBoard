package com.example.SportLeaderboard.Schedule;

import com.example.SportLeaderboard.Module.Standing;
import com.example.SportLeaderboard.Services.StandingService;
import com.example.SportLeaderboard.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
public class Schedule {

    @Autowired
    SlackClient slackClient;

    @Autowired
    StandingService standingService;

    @Scheduled(cron = "0 0 * * 0 0")
    @RequestMapping(value = "getAllItem")
    public List<Standing> getAllStanding() {
        List<Standing> standings = standingService.getAllStanding();
        for (Standing stand : standings) {
            slackClient.sendMessage(String.format("Standing id:" + stand.getId()));
            slackClient.sendMessage(String.format("Team Name:" + stand.getPlayerTeam().getTeamName()));
            slackClient.sendMessage(String.format("Win :" + stand.getWins()));
            slackClient.sendMessage(String.format("Losses:" + stand.getLosses()));
            slackClient.sendMessage(String.format("-----------------------------------"));
        }
        return standings;
    }
}
