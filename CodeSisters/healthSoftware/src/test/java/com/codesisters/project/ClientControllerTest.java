package com.codesisters.project;

import com.codesisters.project.endpoint.ClientEndpoint;
import com.codesisters.project.entity.Client;
import com.codesisters.project.repository.ClientRepository;
import com.codesisters.project.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class) //por ser teste de integração
@SpringBootTest //também por ser integração
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ProjectApplication.class })
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;
        // simulação de um servidor pra chamar os endpoints

    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private ClientService clientService;

    @Test
    public void save_ShouldPersistData() throws Exception {

        Date birthDate = new Date(1990, 12, 4);
        Date startDate = new Date(2023, 11, 22);
        long phoneNumber = 11111111;

        Client client = new Client(
                "11111111111",
                "Client",
                birthDate,
                "Brasília",
                "DF",
                phoneNumber,
                startDate
        );

//        Mockito.when(clientRepository.save(client)).thenReturn(client);
        given(clientRepository.save(client)).willReturn(client);

        ObjectMapper objectMapper = new ObjectMapper();

        this.mockMvc.perform(post("/clients")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(client)))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
    }

    @Test
    public void listAll_ShouldRetrieveAllData() throws Exception {
        Date birthDate = new Date(1990, 12, 4);
        Date startDate = new Date(2023, 11, 22);
        long phoneNumber = 11111111;

        Client client = new Client(
                "11111111111",
                "Client",
                birthDate,
                "Brasília",
                "DF",
                phoneNumber,
                startDate
        );

        Date birthDate2 = new Date(1982, 3, 14);
        Date startDate2 = new Date(2023, 11, 29);
        long phoneNumber2 = 11111111;

        Client client2 = new Client(
                "11111111111",
                "Client2",
                birthDate2,
                "Brasília",
                "DF",
                phoneNumber2,
                startDate2
        );

        given(clientRepository.save(client)).willReturn(client);
        given(clientRepository.save(client2)).willReturn(client2);
        given(clientRepository.findAll()).willReturn(Arrays.asList(client, client2));

//        ObjectMapper objectMapper = new ObjectMapper();

        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);

        mockMvc.perform(get("/clients"))
                .andDo(print())
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(clientRepository.findAll())))
//                        .contentType("application/json"))
//                        .content(objectMapper.writeValueAsString(clientRepository.findAll()))) //converte o client em  String
                         .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Client"))
                .andExpect(jsonPath("$[0].name").value("Client2"));//1º assert do teste

//        List<Client> clients = (List<Client>) clientRepository.findAll();

        System.out.println(clients);
//        Assert.assertEquals(2, clients.size());
        Assert.assertTrue(clients.contains(client));
        Assert.assertTrue(clients.contains(client2));
    }

    @Test
    public void findById_ShouldRetrieveDataByItsId() throws Exception {
        Date birthDate = new Date(1990, 12, 4);
        Date startDate = new Date(2023, 11, 22);
        long phoneNumber = 11111111;

        Client client = new Client(
                "11111111111",
                "Client",
                birthDate,
                "Brasília",
                "DF",
                phoneNumber,
                startDate
        );

        clientRepository.findById(client.getClientId());

    }

//    @Test
//    public void

}
