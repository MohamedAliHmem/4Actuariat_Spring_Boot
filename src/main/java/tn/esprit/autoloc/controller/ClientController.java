package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client created = clientService.addClient(client);
        return ResponseEntity.created(URI.create("/clients/" + created.getIdClient())).body(created);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = clientService.findClientById(id);
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        if (clientService.findClientById(id) == null) return ResponseEntity.notFound().build();
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clientService.findClientById(id) == null) return ResponseEntity.notFound().build();
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
