package com.example.prise_de_rendezvous;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String Ville;
    private String Centre;
    private String reference;
    private String nomDonneur;
    private String date;
}
