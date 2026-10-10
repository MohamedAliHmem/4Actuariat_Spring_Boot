package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {
    Agence addAgence(Agence agence);

    Agence updateAgence(Agence agence);

    void deleteAgence(Long idAgence);

    Agence findAgenceById(Long idAgence);

    List<Agence> findAllAgences();
}
