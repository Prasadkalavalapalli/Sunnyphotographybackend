package com.sunnyphotography.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sunnyphotography.www.Repo.Srepo;
import com.sunnyphotography.www.entity.Sentity;

@Service
public class Sservice {

	@Autowired
	Srepo repo;
	
	public ResponseEntity<?> getdetails() {
	    List<Sentity> details = repo.findAll(); 
	    return ResponseEntity.status(200).body(details);
	}
	
	
	public ResponseEntity<String> adddetails(Sentity entity) {
	    repo.save(entity);
	    return ResponseEntity.status(201).body("Details added successfully!");
	}

}
