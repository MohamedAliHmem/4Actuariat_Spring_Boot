package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement addPaiement(Paiement paiement);

    Paiement updatePaiement(Paiement paiement);

    void deletePaiement(Long idPaiement);

    Paiement findPaiementById(Long idPaiement);

    List<Paiement> findAllPaiements();
}
