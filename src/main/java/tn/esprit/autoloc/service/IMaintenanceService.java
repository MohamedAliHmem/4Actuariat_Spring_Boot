package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addMaintenance(Maintenance maintenance);

    Maintenance updateMaintenance(Maintenance maintenance);

    void deleteMaintenance(Long idMaintenance);

    Maintenance findMaintenanceById(Long idMaintenance);

    List<Maintenance> findAllMaintenances();
}
