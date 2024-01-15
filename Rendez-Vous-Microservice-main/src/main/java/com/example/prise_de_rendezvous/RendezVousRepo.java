package com.example.prise_de_rendezvous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
    RendezVous findByReference(String reference);

    List<RendezVous> findRendezVousByNomDonneur(String name);
    List<RendezVous> findAll();
}
