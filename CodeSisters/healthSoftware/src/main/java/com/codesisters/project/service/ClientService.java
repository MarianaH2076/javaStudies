package com.codesisters.project.service;

import com.codesisters.project.entity.Client;
import com.codesisters.project.error.CustomErrorType;
import com.codesisters.project.repository.ClientRepository;
import com.codesisters.project.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ReportRepository reportRepository;

    public ClientService(ClientRepository clientRepository, ReportRepository reportRepository) {
        this.clientRepository = clientRepository;
        this.reportRepository = reportRepository;
    }

    public Client save(Client client){
        Client newClient = clientRepository.save(client);
        return newClient;
    }

    public List<Client> listAll(){
        return (List<Client>) clientRepository.findAll();
    }

    public Client findById(String clientId){

        Optional<Client> clientToFind = clientRepository.findById(clientId);

        if(clientToFind.isPresent()){
            return clientToFind.get();
        } else {
            throw new CustomErrorType("Client not found", HttpStatus.NOT_FOUND);
        }

    }

    public Client update(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findByName(String name){
        return clientRepository.findByNameIgnoreCaseContaining(name);
    }

    public void delete(String clientId){
        Optional<Client> clientToDelete = clientRepository.findById(clientId);

        if(clientToDelete.isPresent()){
            clientRepository.delete(clientToDelete.get());
        } else {
            throw new CustomErrorType("Client not found", HttpStatus.NOT_FOUND);
        }

    }

}
