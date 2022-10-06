package fr.eni.tpcaveAVin.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Sort;

import fr.eni.tpcaveAVin.bo.Bouteille;

public interface BouteilleService {

	List<Bouteille> getBouteilles() throws SQLException;

	Bouteille getBouteilleByID(int id) throws SQLException;

	void ajouterBouteille(Bouteille bouteille) throws SQLException;

	void supprimerBouteille(int id) throws SQLException;

	void modifierBouteille(Bouteille bouteille) throws SQLException;

	List<Bouteille> findAll(Sort.Direction direction, String key) throws SQLException;

}
