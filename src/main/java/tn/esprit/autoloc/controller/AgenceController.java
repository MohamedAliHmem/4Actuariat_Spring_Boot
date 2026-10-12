package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping
    public ResponseEntity<Agence> create(@RequestBody Agence agence) {
        Agence created = agenceService.addAgence(agence);
        return ResponseEntity.created(URI.create("/agences/" + created.getIdAgence())).body(created);
    }

    @GetMapping
    public List<Agence> findAll() {
        return agenceService.findAllAgences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> findById(@PathVariable Long id) {
        Agence agence = agenceService.findAgenceById(id);
        return agence == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(agence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.findAgenceById(id) == null) return ResponseEntity.notFound().build();
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (agenceService.findAgenceById(id) == null) return ResponseEntity.notFound().build();
        agenceService.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }
}
