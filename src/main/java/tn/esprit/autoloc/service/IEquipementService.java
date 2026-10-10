package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);

    Equipement updateEquipement(Equipement equipement);

    void deleteEquipement(Long idEquipement);

    Equipement findEquipementById(Long idEquipement);

    List<Equipement> findAllEquipements();
}
