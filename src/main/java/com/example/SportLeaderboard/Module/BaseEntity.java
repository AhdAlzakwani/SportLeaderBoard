package com.example.SportLeaderboard.Module;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@Data
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @UpdateTimestamp
    Date updateDate;

    String isActive;

}
