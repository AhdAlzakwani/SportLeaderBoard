package com.example.SportLeaderboard.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JasperReportsToDisplayTheLeaderboardStandingDTO {
    Integer leaderBoardId;
    Integer playerTeamId;
    String teamName;

    public JasperReportsToDisplayTheLeaderboardStandingDTO(Integer leaderBoardId, Integer playerTeamId, String teamName, Integer win, Integer loss) {
        this.leaderBoardId = leaderBoardId;
        this.playerTeamId = playerTeamId;
        this.teamName = teamName;
        this.win = win;
        this.loss = loss;
    }

    Integer win;
    Integer loss;
}
