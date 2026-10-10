package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IEmployeService {
    Employe addEmploye(Employe employe);

    Employe updateEmploye(Employe employe);

    void deleteEmploye(Long idEmploye);

    Employe findEmployeById(Long idEmploye);

    List<Employe> findAllEmployes();
}
