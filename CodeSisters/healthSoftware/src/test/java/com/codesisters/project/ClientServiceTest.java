package com.codesisters.project;

import com.codesisters.project.entity.Client;
import com.codesisters.project.error.CustomErrorType;
import com.codesisters.project.repository.ClientRepository;
import com.codesisters.project.repository.ReportRepository;
import com.codesisters.project.service.ClientService;
import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ReportRepository reportRepository;
    @InjectMocks
    private ClientService clientService;
    private Client client;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void save_ShouldPersistData() throws ParseException {
        clientService = new ClientService(clientRepository, reportRepository);

        String clientId = UUID.randomUUID().toString();
        Date birthDate = new Date(1990, 12, 4);
        Date startDate = new Date(2023, 11, 22);
        long phoneNumber = 11111111;

        client = new Client(
                clientId,
                "11111111111",
                "Client",
                birthDate,
                "Brasília",
                "DF",
                phoneNumber,
                startDate
        );

        when(clientRepository.save(client)).thenReturn(client);
        Client savedClient = clientService.save(client);

        Assert.assertNotNull(savedClient);
        Assert.assertEquals(savedClient.getClientId(), client.getClientId());
        Assert.assertEquals(savedClient.getCpf(), client.getCpf());
        Assert.assertEquals(savedClient.getName(), client.getName());
        Assert.assertEquals(savedClient.getBirthDate(), client.getBirthDate());
        Assert.assertEquals(savedClient.getUf(), client.getUf());
        Assert.assertEquals(savedClient.getPhoneNumber(), client.getPhoneNumber());
        Assert.assertEquals(savedClient.getStartDate(), client.getStartDate());
    }

    @Test
    public void listAll_ShouldReturnAllData(){
        clientService = new ClientService(clientRepository, reportRepository);
        String clientId1 = UUID.randomUUID().toString();
        String clientId2 = UUID.randomUUID().toString();
        client = new Client(clientId1);
        Client client2 = new Client(clientId2);

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        clientList.add(client2);

        when(clientRepository.findAll()).thenReturn(clientList);
        List<Client> result = clientService.listAll();

        Assert.assertArrayEquals(clientList.toArray(), result.toArray());
    }

    @Test
    public void findById_ShouldThrowAnErrorIfClientIsEmpty(){
        clientService = new ClientService(clientRepository, reportRepository);
        String clientId = UUID.randomUUID().toString();
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomErrorType.class, () -> clientService.findById(clientId));
    }

    @Test
    public void findById_ShouldReturnClientIfIdMatchesAnObject(){
        clientService = new ClientService(clientRepository, reportRepository);
        String clientId = UUID.randomUUID().toString();
//        client = new Client("cliente1", "11111111111", clientId);
        client = new Client(clientId);
        when(clientRepository.findById(client.getClientId())).thenReturn(Optional.of(client));

        Client clientToFind = clientService.findById(client.getClientId());

        Assert.assertEquals(client.getClientId(), clientToFind.getClientId());
    }

    @Test
    public void update_ShouldChangeAndPersistData(){
        clientService = new ClientService(clientRepository, reportRepository);
//        client = new Client("cliente1", "11111111111");
        String clientId = UUID.randomUUID().toString();
        Date birthDate = new Date(1990, 12, 4);
        Date startDate = new Date(2023, 11, 22);
        long phoneNumber = 11111111;

        client = new Client(
                clientId,
                "11111111111",
                "Client",
                birthDate,
                "Brasília",
                "DF",
                phoneNumber,
                startDate
        );

        when(clientRepository.save(client)).thenReturn(client);

        String newClientId = UUID.randomUUID().toString();
        client.setClientId(newClientId);
        client.setName("Client New Name");
        client.setCpf("22222222222");
        client.setCity("São Paulo");
        client.setUf("SP");
        client.setBirthDate(new Date(1983, 4, 23));
        client.setStartDate(new Date(2023, 12, 1));
        client.setPhoneNumber(222222222L);

        Client updatedClient = clientService.update(client);

        Assert.assertEquals(client.getClientId(), updatedClient.getClientId());
        Assert.assertEquals(client.getCity(), updatedClient.getCity());
        Assert.assertEquals(client.getName(), updatedClient.getName());
        Assert.assertEquals(client.getUf(), updatedClient.getUf());
        Assert.assertEquals(client.getCpf(), updatedClient.getCpf());
        Assert.assertEquals(client.getStartDate(), updatedClient.getStartDate());
        Assert.assertEquals(client.getBirthDate(), updatedClient.getBirthDate());
        Assert.assertEquals(client.getPhoneNumber(), updatedClient.getPhoneNumber());
    }

    @Test
    public void findByName_ShouldReturnAClientByItsName(){
        clientService = new ClientService(clientRepository, reportRepository);
        client = new Client("cliente1", "11111111111");

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        when(clientRepository.findByNameIgnoreCaseContaining(client.getName())).thenReturn(clientList);

        List<Client> clientToFind = clientService.findByName(client.getName());

        Assert.assertArrayEquals(clientList.toArray(), clientToFind.toArray());
    }

    @Test
    public void delete_ShouldRemoveData(){
        clientService = new ClientService(clientRepository, reportRepository);
        String clientId = UUID.randomUUID().toString();
        client = new Client(clientId);

        when(clientRepository.findById(client.getClientId())).thenReturn(Optional.of(client));

        clientService.delete(client.getClientId());

        verify(clientRepository).delete(client);
    }

    @Test
    public void delete_ShouldThrowErrorIfClientIsNotFound(){
        clientService = new ClientService(clientRepository, reportRepository);
        String clientId = UUID.randomUUID().toString();
        client = new Client(clientId);

        when(clientRepository.findById(client.getClientId())).thenReturn(Optional.empty());

        Assert.assertThrows(CustomErrorType.class, () -> clientService.delete(client.getClientId()));
    }

}
