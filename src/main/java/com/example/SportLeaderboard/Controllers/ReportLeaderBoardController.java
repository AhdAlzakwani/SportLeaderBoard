package com.example.SportLeaderboard.Controllers;

import com.example.SportLeaderboard.Services.ReportLeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportLeaderBoardController {
    @Autowired
    ReportLeaderBoardService reportLeaderBoardService;


    @RequestMapping(value = "api/generateJasperReportsToDisplayTheLeaderboardStanding", method = RequestMethod.GET)
    public void generateReport() throws Exception {
        reportLeaderBoardService.generateJasperReportsToDisplayTheLeaderboardStanding();

    }



}
