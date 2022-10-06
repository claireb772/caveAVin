package fr.eni.tpcaveAVin.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import fr.eni.tpcaveAVin.bo.SortReact;

@RestController
public class CaveAVinRestController {

	private BouteilleService bouteilleService;

	@Autowired
	public CaveAVinRestController(BouteilleService bouteilleService) {
		this.bouteilleService = bouteilleService;
	}

	@PostMapping("/cave")
	public ResponseEntity<?> getListBouteille(@RequestBody SortReact sortParam) {
		List<Bouteille> listBouteille;
		String direction = sortParam.getDirection();
		String key = sortParam.getKey();

		Sort.Direction dir;

		if (direction.equals(null) || direction.equals("") || direction.equals("undefined")
				|| direction.equals("DESC")) {
			dir = Sort.Direction.ASC;

		} else {
			dir = Sort.Direction.DESC;
		}

		if (key.equals(null) | key.equals("") | key.equals("undefined")) {
			key = "nom";
		}

		System.out.println("tri " + direction + "key " + key);

		try {
			listBouteille = bouteilleService.findAll(dir, key);
		} catch (SQLException e) {
			String message = "Erreur à la récupération en base";
			e.printStackTrace();
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(listBouteille, HttpStatus.OK);
	}

	@GetMapping("/bouteille/{id}")
	public ResponseEntity<?> getBouteille(@PathVariable("id") int id) {
		Bouteille bouteille;
		try {
			bouteille = bouteilleService.getBouteilleByID(id);
		} catch (SQLException e) {
			String message = "Erreur à la récupération en base";
			e.printStackTrace();
			return new ResponseEntity<>(message, HttpStatus.OK);
		}

		return new ResponseEntity<>(bouteille, HttpStatus.OK);
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

		try {
			bouteilleService.ajouterBouteille(bouteille);
		} catch (SQLException e) {
			String message = "Erreur à l'insertion en base";
			e.printStackTrace();
			return new ResponseEntity<>(message, HttpStatus.OK);
		}

		return new ResponseEntity<Bouteille>(bouteille, HttpStatus.CREATED);

	}

	@PutMapping("/updateBouteille")
	public ResponseEntity<?> updateBouteille(@RequestBody Bouteille bouteille) {

		try {
			bouteilleService.modifierBouteille(bouteille);
		} catch (SQLException e) {
			String message = "Erreur à la modification en base";
			e.printStackTrace();
			return new ResponseEntity<>(message, HttpStatus.OK);
		}

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
