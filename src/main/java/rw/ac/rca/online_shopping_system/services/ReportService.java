package rw.ac.rca.online_shopping_system.services;

import rw.ac.rca.online_shopping_system.DTO.ReportDTO;

import java.util.List;

public interface ReportService {
    List<ReportDTO> generateReport();
}
