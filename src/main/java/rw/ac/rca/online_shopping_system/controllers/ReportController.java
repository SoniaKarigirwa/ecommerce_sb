package rw.ac.rca.online_shopping_system.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.online_shopping_system.services.ReportService;

@RestController
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }
}
