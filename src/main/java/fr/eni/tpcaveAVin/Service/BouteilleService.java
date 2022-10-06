package fr.eni.tpcaveAVin.Service;

import java.util.List;

import fr.eni.tpcaveAVin.bo.Bouteille;

public interface BouteilleService {

	List<Bouteille> getBouteilles();

	Bouteille getBouteilleByID(int id);

	void ajouterBouteille(Bouteille bouteille);

	void supprimerBouteille(int id);

	void modifierBouteille(Bouteille bouteille);

	void modifierPartiellementBouteille(int id, Bouteille bouteille);

}
