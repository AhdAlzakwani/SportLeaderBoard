package com.example.SportLeaderboard.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class NewGameCreation {

    Integer score;
    String teamName;
    String isActive;
}
