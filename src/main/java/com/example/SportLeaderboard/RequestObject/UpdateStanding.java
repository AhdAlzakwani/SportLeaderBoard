package com.example.SportLeaderboard.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UpdateStanding {
    Integer id;
    Integer wins;

    Integer losses;

    String teamName;
}
