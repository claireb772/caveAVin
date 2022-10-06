package fr.eni.tpcaveAVin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.tpcaveAVin.bo.Bouteille;

public interface BouteilleRepository extends JpaRepository<Bouteille, Integer> {

}
