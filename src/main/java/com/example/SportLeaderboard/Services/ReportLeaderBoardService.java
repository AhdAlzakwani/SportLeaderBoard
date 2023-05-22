package com.example.SportLeaderboard.Services;


import com.example.SportLeaderboard.Module.LeaderBoard;
import com.example.SportLeaderboard.Repositories.LeaderBoardRepository;
import com.example.SportLeaderboard.RequestObject.JasperReportsToDisplayTheLeaderboardStandingDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportLeaderBoardService {

@Autowired
    LeaderBoardRepository leaderBoardRepository;
    public static final String pathToReports = "C:\\Users\\User009\\Documents\\task1\\Task1\\JasperReport";
    public String  generateJasperReportsToDisplayTheLeaderboardStanding() throws JRException {
        List<LeaderBoard> leaderBoards = leaderBoardRepository.findAll();
        List<JasperReportsToDisplayTheLeaderboardStandingDTO> jasperReportsToDisplayTheLeaderboardStandingDTOS = new ArrayList<>();
        for (LeaderBoard l: leaderBoards) {
            Integer leaderBoardId = l.getId();
            Integer playerTeamId = l.getStanding().getPlayerTeam().getId();
            String teamName = l.getStanding().getPlayerTeam().getTeamName();
            Integer win = l.getWins();
            Integer loss = l.getLosses();

            JasperReportsToDisplayTheLeaderboardStandingDTO jasperReportsToDisplayTheLeaderboardStandingDTOList = new
                    JasperReportsToDisplayTheLeaderboardStandingDTO(leaderBoardId, playerTeamId, teamName, win, loss);
            jasperReportsToDisplayTheLeaderboardStandingDTOS.add(jasperReportsToDisplayTheLeaderboardStandingDTOList);

        }




            File file = new File("C:\\Users\\User009\\Documents\\task1\\Task1\\src\\main\\resources\\generateJasperReportsToDisplayTheLeaderboardStanding.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(jasperReportsToDisplayTheLeaderboardStandingDTOS);
            Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "AhdYahya");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\generateJasperReportsToDisplayTheLeaderboardStanding.pdf");
            return "Report generated : " + pathToReports+"\\generateJasperReportsToDisplayTheLeaderboardStanding.pdf";
        }


}
