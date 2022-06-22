package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognixia.jump.model.Card;
import com.cognixia.jump.repository.CardRepository;

public class CardService {
	@Autowired
	CardRepository repo;
	
	public List<Card> getStudents() {
		return repo.findAll();
	}
	
	public Optional<Card> getStudentById(int id){
		return repo.findById(id);
	}
}
