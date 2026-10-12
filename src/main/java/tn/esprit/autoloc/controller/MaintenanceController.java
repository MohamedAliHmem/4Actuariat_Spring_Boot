package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance maintenance) {
        Maintenance created = maintenanceService.addMaintenance(maintenance);
        return ResponseEntity.created(URI.create("/maintenances/" + created.getIdMaintenance())).body(created);
    }

    @GetMapping
    public List<Maintenance> findAll() {
        return maintenanceService.findAllMaintenances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> findById(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.findMaintenanceById(id);
        return maintenance == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(maintenance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        if (maintenanceService.findMaintenanceById(id) == null) return ResponseEntity.notFound().build();
        maintenance.setIdMaintenance(id);
        return ResponseEntity.ok(maintenanceService.updateMaintenance(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (maintenanceService.findMaintenanceById(id) == null) return ResponseEntity.notFound().build();
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
