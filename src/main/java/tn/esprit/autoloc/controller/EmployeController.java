package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> create(@RequestBody Employe employe) {
        Employe created = employeService.addEmploye(employe);
        return ResponseEntity.created(URI.create("/employes/" + created.getIdEmploye())).body(created);
    }

    @GetMapping
    public List<Employe> findAll() {
        return employeService.findAllEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> findById(@PathVariable Long id) {
        Employe employe = employeService.findEmployeById(id);
        return employe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        if (employeService.findEmployeById(id) == null) return ResponseEntity.notFound().build();
        employe.setIdEmploye(id);
        return ResponseEntity.ok(employeService.updateEmploye(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (employeService.findEmployeById(id) == null) return ResponseEntity.notFound().build();
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
