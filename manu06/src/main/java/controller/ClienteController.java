package controller;

import models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.ClienteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        clienteService.deleteCliente(id);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){
        ClienteModel request = clienteService.criarCliente(clienteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clienteModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(request);
    }


}