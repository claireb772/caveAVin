package fr.eni.tpcaveAVin.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<Bouteille>> getListBouteille() {
		List<Bouteille> listBouteille = bouteilleService.getBouteilles();
		return new ResponseEntity<List<Bouteille>>(listBouteille, HttpStatus.OK);

	}

	@GetMapping("/bouteille/{id}")
	public ResponseEntity<Bouteille> getBouteille(@PathVariable("id") int id) {
		Bouteille bouteille = bouteilleService.getBouteilleByID(id);

		return new ResponseEntity<Bouteille>(bouteille, HttpStatus.OK);
	}

	@PostMapping("/createBouteille")
	public ResponseEntity<?> ajouterBouteille(@Valid @RequestBody Bouteille bouteille, BindingResult validationResult) {

		if (bouteille.getId() <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (validationResult.hasErrors()) {
			List<String> messages = new ArrayList<>();
			List<ObjectError> Listmessage = validationResult.getAllErrors();
			for (ObjectError objectError : Listmessage) {
				messages.add(objectError.getDefaultMessage());
			}

			return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
		}

		bouteilleService.ajouterBouteille(bouteille);

		return new ResponseEntity<Bouteille>(bouteille, HttpStatus.CREATED);

	}

	@PutMapping("/updateBouteille")
	public ResponseEntity<?> updateBouteille(@RequestBody Bouteille bouteille) {

		bouteilleService.modifierBouteille(bouteille);

		return new ResponseEntity<>(bouteille, HttpStatus.OK);
	}

	@DeleteMapping("/bouteille/{id}")
	public ResponseEntity<String> supprimerBouteille(@PathVariable("id") int id) {
		String message;
		try {
			bouteilleService.supprimerBouteille(id);
		} catch (Exception e) {
			message = String.format("Erreur à la suppression de la bouteille %d", id);
			return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

		}

		message = String.format("La bouteille %d a été supprimée", id);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);

	}

}
