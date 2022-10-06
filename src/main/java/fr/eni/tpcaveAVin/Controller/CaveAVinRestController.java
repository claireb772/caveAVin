package fr.eni.tpcaveAVin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.tpcaveAVin.Service.BouteilleService;
import fr.eni.tpcaveAVin.bo.Bouteille;

@RestController
public class CaveAVinRestController {

	private BouteilleService bouteilleService;

	@Autowired
	public CaveAVinRestController(BouteilleService bouteilleService) {
		this.bouteilleService = bouteilleService;
	}

	@GetMapping("/cave")
	public List<Bouteille> getListBouteille() {
		return bouteilleService.getBouteilles();

	}

	@PostMapping("/createBouteille")
	public ResponseEntity<Bouteille> ajouterBouteille(@RequestBody Bouteille bouteille) {

		if (bouteille.getId() <= 0) {
			return new ResponseEntity<Bouteille>(HttpStatus.BAD_REQUEST);
		}

		bouteilleService.ajouterBouteille(bouteille);

		return new ResponseEntity<Bouteille>(bouteille, HttpStatus.CREATED);

	}

}
