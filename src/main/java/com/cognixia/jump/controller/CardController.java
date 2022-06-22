package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Card;
import com.cognixia.jump.repository.CardRepository;

@RestController
@RequestMapping("/api")
public class CardController {

	@Autowired
	CardRepository repo;

	@GetMapping("/card") 
	public List<Card> getCards() {
		return repo.findAll();
	}
	
	@GetMapping("/card/{id}")
	public ResponseEntity<?> getCard(@PathVariable int id) {
		Optional<Card> found = repo.findById(id);

		if (found.isEmpty()) {
			return ResponseEntity.status(404).body("Card with id = " + id + " not found");
		} else {
			return ResponseEntity.status(200).body(found.get());
		}
	}
	
	@PostMapping("/card")
	public ResponseEntity<?> createCard(@RequestBody Card card) {

		card.setId(null);

		Card created = repo.save(card);

		return ResponseEntity.status(201).body(created);
	}
	
	
	
	@PutMapping("/card")
	public ResponseEntity<?> updateCard(@RequestBody Card card){
		
		boolean exists = repo.existsById(card.getId());
		
		if(exists) {
			Card updated = repo.save(null);
			return ResponseEntity.status(200).body(updated);
		}
		else{
			return ResponseEntity.status(404).body("Can't perform update: card does not exist");
		}
	}

	@DeleteMapping("/card/{id}")
	public ResponseEntity<?> deleteCard(@PathVariable int id) {
		boolean exists = repo.existsById(id);
		
		if(exists) {
			repo.deleteById(id);
			
			return ResponseEntity.status(200).body("Card was deleted");
		}
		else {
			return ResponseEntity.status(404).body("Can't perform deletion: card does not exist");

		}
	}
	
	@PatchMapping("/card/design")
	public ResponseEntity<?> updateCard(@PathParam(value = "id") int id, @PathParam(value = "design") String design){
		
		Optional<Card> found = repo.findById(id);
		
		if(found.isEmpty()) {
			return ResponseEntity.status(404).body("Card with that id not found");
		}
		else {
			Card toUpdate = found.get();
			
			toUpdate.setDesign(design);
			
			repo.save(toUpdate);
			
			return ResponseEntity.status(200).body("The design for the card was changed");
		}
	}

}
