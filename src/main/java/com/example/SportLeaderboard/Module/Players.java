package com.example.SportLeaderboard.Module;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    String playerName;

    String password;

    @ManyToOne
    @JoinColumn(name = "Team_id", referencedColumnName = "id")// defining the foreign key which is ID
    PlayerTeam playerTeam;
}
