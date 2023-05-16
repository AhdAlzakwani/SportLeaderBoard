package com.example.SportLeaderboard.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class NewStanding {

    Integer wins;

    Integer losses;

    String teamName;


}
