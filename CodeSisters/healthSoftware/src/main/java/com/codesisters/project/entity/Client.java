package com.codesisters.project.entity;

import com.codesisters.project.entity.uf.UF;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "city")
    private String city;

    @Column(name = "uf")
    private String uf;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "start_date")
    private Date startDate;

    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Report> reports;

    public Client() {
    }


    public Client(String name, String cpf) {
        this.cpf = cpf;
        this.name = name;
    }

    public Client(String cpf, String name, Date birthDate, String city, String uf, Long phoneNumber, Date startDate) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.uf = uf;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
    }

    public Client(String clientId, String cpf, String name, Date birthDate, String city, String uf, Long phoneNumber, Date startDate) {
        this.clientId = clientId;
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.uf = uf;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
    }

    public Client(String clientId) {
        this.clientId = clientId;
    }

    public Client(String name, String cpf, String clientId) {
        this.cpf = cpf;
        this.name = name;
        this.clientId = clientId;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}

