package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {
    private final IContratService contratService;

    @PostMapping
    public ResponseEntity<Contrat> create(@RequestBody Contrat contrat) {
        Contrat created = contratService.addContrat(contrat);
        return ResponseEntity.created(URI.create("/contrats/" + created.getIdContrat())).body(created);
    }

    @GetMapping
    public List<Contrat> findAll() {
        return contratService.findAllContrats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> findById(@PathVariable Long id) {
        Contrat contrat = contratService.findContratById(id);
        return contrat == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(contrat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        if (contratService.findContratById(id) == null) return ResponseEntity.notFound().build();
        contrat.setIdContrat(id);
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (contratService.findContratById(id) == null) return ResponseEntity.notFound().build();
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
