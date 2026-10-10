package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {
    Contrat addContrat(Contrat contrat);

    Contrat updateContrat(Contrat contrat);

    void deleteContrat(Long idContrat);

    Contrat findContratById(Long idContrat);

    List<Contrat> findAllContrats();
}
