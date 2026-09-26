package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idAgence;

    @ToString.Include
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @Builder.Default
    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    private List<Employe> employes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    private List<Vehicule> vehicules = new ArrayList<>();
}
