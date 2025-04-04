package com.sunnyphotography.www.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunnyphotography.www.Repo.Srepo;
import com.sunnyphotography.www.entity.Sentity;
import com.sunnyphotography.www.service.Sservice;

@CrossOrigin("*")
@RestController
public class Scontroller {
	
	@Autowired
	Sservice serv;
	@Autowired
	Srepo repo;
	
	@GetMapping("/getbookings")
	public ResponseEntity<?> getdetails()
	{
		return serv.getdetails();
	}
	@PostMapping("/postbookings")
	public ResponseEntity<String> adddetails(@RequestBody Sentity entity)
	{
		return serv.adddetails(entity);
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<?> updateStatus(@RequestBody Map<String, String> update) {
	    Long id = Long.parseLong(update.get("id"));
	    String newStatus = update.get("status");

	    Optional<Sentity> booking = repo.findById(id);
	    if (booking.isPresent()) {
	        Sentity entity = booking.get();
	        entity.setStatus(newStatus);
	        repo.save(entity);
	        return ResponseEntity.ok("Status updated successfully");
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
	}

}
