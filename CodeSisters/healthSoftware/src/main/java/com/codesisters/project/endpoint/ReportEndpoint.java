package com.codesisters.project.endpoint;

import com.codesisters.project.entity.Report;
import com.codesisters.project.repository.ReportRepository;
import com.codesisters.project.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("reports")
public class ReportEndpoint {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ReportService reportService;

    @PostMapping("/{clientId}")
    public ResponseEntity<Report> save(@PathVariable String clientId, @RequestBody Report report){
        Report newReport = reportService.save(clientId, report);
        return ResponseEntity.ok().body(newReport);
    }

    @GetMapping
    public ResponseEntity<List<Report>> listAll(){
        List<Report> reports = reportService.listAll();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> listById(@PathVariable("id") String id){
        Report report = reportService.listById(id);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Report report){
        Report updatedReport = reportService.update(report);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String reportId){
        reportService.delete(reportId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
