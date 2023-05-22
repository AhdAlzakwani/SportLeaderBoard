package com.example.SportLeaderboard.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdatePlayers {
    Integer id;
    String playerName;

    String password;

    String teamName;

}
