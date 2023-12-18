package com.codesisters.project.service;

import com.codesisters.project.entity.Client;
import com.codesisters.project.entity.Report;
import com.codesisters.project.error.CustomErrorType;
import com.codesisters.project.repository.ClientRepository;
import com.codesisters.project.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;
    @Autowired
    private ClientRepository clientRepository;

    public ReportService(ReportRepository reportRepository, ClientRepository clientRepository) {
        this.reportRepository = reportRepository;
        this.clientRepository = clientRepository;
    }

    public Report save(String clientId, Report report){
        Optional<Client> client = clientRepository.findById(clientId);
        report.setClientId(client.get());
        return reportRepository.save(report);
    }

    public List<Report> listAll(){
        return (List<Report>) reportRepository.findAll();
    }

    public Report listById(String reportId){
        Optional<Report> reportToFind = reportRepository.findById(reportId);

        if(reportToFind.isPresent()){
            return reportToFind.get();
        } else {
            throw new CustomErrorType("Report not found", HttpStatus.NOT_FOUND);
        }
    }

    public Report update(Report report){
        return reportRepository.save(report);
    }

    public void delete(String reportId){

//        Optional<Report> reportToDelete = reportRepository.findById(UUID.fromString(reportId));
        Optional<Report> reportToDelete = reportRepository.findById(reportId);
         if(reportToDelete.isPresent()){
             reportRepository.delete(reportToDelete.get());
         } else {
             throw new CustomErrorType("Report not found", HttpStatus.NOT_FOUND);
         }
    }

}
