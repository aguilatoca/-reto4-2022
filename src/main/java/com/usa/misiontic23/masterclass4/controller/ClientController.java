package com.usa.misiontic23.masterclass4.controller;


import com.usa.misiontic23.masterclass4.entities.Category;
import com.usa.misiontic23.masterclass4.entities.Client;
import com.usa.misiontic23.masterclass4.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")

public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getALL();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client p){
        return clientService.save(p);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client p){
        return ClientService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return ClientService.delete(id);
    }

}
