package fr.eni.tpcaveAVin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.tpcaveAVin.bo.Bouteille;
import fr.eni.tpcaveAVin.bo.Region;
import fr.eni.tpcaveAVin.repository.BouteilleRepository;
import fr.eni.tpcaveAVin.repository.CouleurRepository;
import fr.eni.tpcaveAVin.repository.RegionRepository;

@Service
public class BouteilleServiceImpl implements BouteilleService {

	private BouteilleRepository bouteilleRepository;
	private RegionRepository regionRepository;
	private CouleurRepository couleurRepository;

	@Autowired
	BouteilleServiceImpl(BouteilleRepository bouteilleRepository, RegionRepository regionRepository,
			CouleurRepository couleurRepository) {
		this.bouteilleRepository = bouteilleRepository;
		this.couleurRepository = couleurRepository;
		this.regionRepository = regionRepository;
	}

	@Override
	public List<Bouteille> getBouteilles() {
		return bouteilleRepository.findAll();
	}

	@Override
	public Bouteille getBouteilleByID(int id) {
		return bouteilleRepository.findById(id).get();
	}

	@Override
	public void ajouterBouteille(Bouteille bouteille) {

		bouteilleRepository.save(bouteille);

	}

	@Override
	public void supprimerBouteille(int id) {
		bouteilleRepository.deleteById(id);

	}

	@Override
	public void modifierBouteille(Bouteille bouteille) {
		ajouterBouteille(bouteille);

	}

	public BouteilleRepository getBouteilleRepository() {
		return bouteilleRepository;
	}

	public void setBouteilleRepository(BouteilleRepository bouteilleRepository) {
		this.bouteilleRepository = bouteilleRepository;
	}

	public RegionRepository getRegionRepository() {
		return regionRepository;
	}

	public void setRegionRepository(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}

	public CouleurRepository getCouleurRepository() {
		return couleurRepository;
	}

	public void setCouleurRepository(CouleurRepository couleurRepository) {
		this.couleurRepository = couleurRepository;
	}

	public List<Region> getRegions() {
		return regionRepository.findAll();
	}

}
