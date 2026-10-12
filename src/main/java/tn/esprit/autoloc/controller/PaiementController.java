package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping
    public ResponseEntity<Paiement> create(@RequestBody Paiement paiement) {
        Paiement created = paiementService.addPaiement(paiement);
        return ResponseEntity.created(URI.create("/paiements/" + created.getIdPaiement())).body(created);
    }

    @GetMapping
    public List<Paiement> findAll() {
        return paiementService.findAllPaiements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> findById(@PathVariable Long id) {
        Paiement paiement = paiementService.findPaiementById(id);
        return paiement == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(paiement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement paiement) {
        if (paiementService.findPaiementById(id) == null) return ResponseEntity.notFound().build();
        paiement.setIdPaiement(id);
        return ResponseEntity.ok(paiementService.updatePaiement(paiement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (paiementService.findPaiementById(id) == null) return ResponseEntity.notFound().build();
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
