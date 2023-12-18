package com.codesisters.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="reports")
public class Report {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name="report_id")
    private String reportId;

    @Column(name="session_date")
    private Date sessionDate;

    @Column(name="notes")
    private String notes;

    @Column(name="techniques")
    private String techniques;

    @Column(name="future_notes")
    private String futureNotes;


    @JsonBackReference
    @JoinColumn(name="fk_client_id", referencedColumnName = "client_id")
    @ManyToOne (fetch = FetchType.LAZY)
    private Client clientId;

    public Report(String reportId, String notes) {
        this.reportId = reportId;
        this.notes = notes;
    }

    public Report(UUID reportId, String notes) {
        this.reportId = String.valueOf(reportId);
        this.notes = notes;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Report(){}

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTechniques() {
        return techniques;
    }

    public void setTechniques(String techniques) {
        this.techniques = techniques;
    }

    public String getFutureNotes() {
        return futureNotes;
    }

    public void setFutureNotes(String futureNotes) {
        this.futureNotes = futureNotes;
    }
}
