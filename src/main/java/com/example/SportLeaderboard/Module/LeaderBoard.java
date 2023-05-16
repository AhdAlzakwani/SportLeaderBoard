package com.example.SportLeaderboard.Module;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class LeaderBoard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer wins;

    Integer losses;


    @ManyToOne
    @JoinColumn(name = "standing_id", referencedColumnName = "id")// defining the foreign key which is ID
    Standing standing;




}
