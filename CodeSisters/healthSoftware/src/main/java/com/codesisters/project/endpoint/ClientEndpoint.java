package com.codesisters.project.endpoint;

import com.codesisters.project.entity.Client;
import com.codesisters.project.repository.ClientRepository;
import com.codesisters.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@ComponentScan(basePackages = {"com.codesisters.project", "com.codesisters.project.endpoint"}) //para fazer os testes
public class ClientEndpoint {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client newClient = clientService.save(client);
        return ResponseEntity.ok().body(newClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> listAll(){
        List<Client> list = clientService.listAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") String clientId){
        Client client = clientService.findById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Client>> findByName(@PathVariable("name") String name){
        List<Client> client = clientService.findByName(name);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Void> update(@RequestBody Client client){
        Client updatedClient = clientService.update(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String clientId){
        clientService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
