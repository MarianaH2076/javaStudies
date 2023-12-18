//package com.codesisters.project;
//
//import com.codesisters.project.entity.Client;
//import com.codesisters.project.entity.Report;
//import com.codesisters.project.error.CustomErrorType;
//import com.codesisters.project.repository.ClientRepository;
//import com.codesisters.project.repository.ReportRepository;
//import com.codesisters.project.service.ReportService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ReportServiceTest {
//
//    @Mock
//    private ReportRepository reportRepository;
//    @Mock
//    private ClientRepository clientRepository;
//    @InjectMocks
//    private ReportService reportService;
//
//    private Report report;
//
//    @Before
//    public void init(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void save_ShouldPersistData(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        String clientId = UUID.randomUUID().toString();
//        Client client = new Client(clientId);
//
//        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
//
//        report = new Report("1", "good");
//
//        when(reportRepository.save(report)).thenReturn(report);
//
//        Report savedReport = reportService.save(clientId, report);
//
//        Assert.assertNotNull(savedReport);
//        Assert.assertEquals(report.getReportId(), savedReport.getReportId());
//        Assert.assertEquals(report.getNotes(), savedReport.getNotes());
//    }
//
//    @Test
//    public void listAll_ShouldReturnAllSavedReports(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        UUID clientId = UUID.randomUUID();
//        Client client = new Client(clientId);
//        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
//
//        report = new Report("1", "good");
//        when(reportRepository.save(report)).thenReturn(report);
//
//        List<Report> reportList = new ArrayList<>();
//        reportList.add(report);
//
//        when(reportRepository.findAll()).thenReturn(reportList);
//
//        List<Report> result = reportService.listAll();
//
//        Assert.assertArrayEquals(reportList.toArray(), result.toArray());
//    }
//
//    @Test
//    public void listById_ShouldReturnAReportByItsId(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        UUID clientId = UUID.randomUUID();
//        Client client = new Client(clientId);
//        when(clientRepository.findById(client.getClientId())).thenReturn(Optional.of(client));
//
//        UUID reportId = UUID.randomUUID();
//        report = new Report(reportId, "good");
//        when(reportRepository.save(report)).thenReturn(report);
//
//        when((reportRepository.findById(reportId))).thenReturn(Optional.of(report));
//
//        Report reportToFind = reportService.listById(reportId);
//
//        Assert.assertEquals(report.getReportId(), reportToFind.getReportId());
//
//    }
//
//    @Test
//    public void listById_ShouldThrowErrorIfReportIsNotFound(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        UUID clientId = UUID.randomUUID();
//        Client client = new Client(clientId);
//        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
//
//        UUID reportId = UUID.randomUUID();
//        report = new Report(reportId, "good");
//        when(reportRepository.save(report)).thenReturn(report);
//
//        when((reportRepository.findById(reportId))).thenReturn(Optional.empty());
//
//        Assertions.assertThrows(CustomErrorType.class, () -> reportService.listById(reportId));
//    }
//
//    @Test
//    public void update_ShouldAlterAndPersistData(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        UUID clientId = UUID.randomUUID();
//        Client client = new Client(clientId);
//        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
//
//        UUID reportId = UUID.randomUUID();
//        report = new Report(reportId, "good");
//        when(reportRepository.save(report)).thenReturn(report);
//
//        Report updatedReport = reportService.update(report);
//        report.setNotes("Great!");
//
//        when(reportRepository.save(report)).thenReturn(report);
//
//        Assert.assertEquals(report.getNotes(), updatedReport.getNotes());
//
//    }
//
//    @Test
//    public void delete_ShouldThrowErrorMessageIfReportIsEmpty(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        UUID reportId = UUID.randomUUID();
//        report = new Report(reportId, "note");
//        when(reportRepository.findById(reportId)).thenReturn(Optional.empty());
//
//        //Act and Assert
//        assertThrows(CustomErrorType.class, () -> reportService.delete(reportId.toString()));
//
//    }
//
//    @Test
//    public void delete_ShouldRemoveData(){
//        reportService = new ReportService(reportRepository, clientRepository);
//
//        UUID reportId = UUID.randomUUID();
//        UUID reportId2 = UUID.randomUUID();
//        report = new Report(reportId, "good");
//
//        when(reportRepository.findById(reportId)).thenReturn(Optional.of(report));
//
//        reportService.delete(reportId.toString());
//
//        verify(reportRepository, times(1)).delete(report);
//
//    }
//
//}
