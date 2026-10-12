package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping
    public ResponseEntity<Equipement> create(@RequestBody Equipement equipement) {
        Equipement created = equipementService.addEquipement(equipement);
        return ResponseEntity.created(URI.create("/equipements/" + created.getIdEquipement())).body(created);
    }

    @GetMapping
    public List<Equipement> findAll() {
        return equipementService.findAllEquipements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> findById(@PathVariable Long id) {
        Equipement equipement = equipementService.findEquipementById(id);
        return equipement == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(equipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> update(@PathVariable Long id, @RequestBody Equipement equipement) {
        if (equipementService.findEquipementById(id) == null) return ResponseEntity.notFound().build();
        equipement.setIdEquipement(id);
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (equipementService.findEquipementById(id) == null) return ResponseEntity.notFound().build();
        equipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
