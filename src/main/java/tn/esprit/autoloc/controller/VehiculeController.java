package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<Vehicule> create(@RequestBody Vehicule vehicule) {
        Vehicule created = vehiculeService.addVehicule(vehicule);
        return ResponseEntity.created(URI.create("/vehicules/" + created.getIdVehicule())).body(created);
    }

    @GetMapping
    public List<Vehicule> findAll() {
        return vehiculeService.findAllVehicules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> findById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.findVehiculeById(id);
        return vehicule == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(vehicule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        if (vehiculeService.findVehiculeById(id) == null) return ResponseEntity.notFound().build();
        vehicule.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.updateVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (vehiculeService.findVehiculeById(id) == null) return ResponseEntity.notFound().build();
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
