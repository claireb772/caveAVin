package fr.eni.tpcaveAVin.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<Bouteille> getBouteilles() throws SQLException {
		try {
			return bouteilleRepository.findAll();
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public Bouteille getBouteilleByID(int id) throws SQLException {
		try {
			return bouteilleRepository.findById(id).get();
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	@Override
	public void ajouterBouteille(Bouteille bouteille) throws SQLException {
		try {
			bouteilleRepository.save(bouteille);
		} catch (Exception e) {
			throw new SQLException();
		}

	}

	@Override
	public void supprimerBouteille(int id) throws SQLException {
		try {
			bouteilleRepository.deleteById(id);
		} catch (Exception e) {
			throw new SQLException();
		}

	}

	@Override
	public void modifierBouteille(Bouteille bouteille) throws SQLException {
		ajouterBouteille(bouteille);

	}

	@Override
	public List<Bouteille> findAll(Sort.Direction direction, String key) throws SQLException {
		try {
			return bouteilleRepository.findAll(Sort.by(direction, key));
		} catch (Exception e) {
			throw new SQLException();
		}
	}
}
