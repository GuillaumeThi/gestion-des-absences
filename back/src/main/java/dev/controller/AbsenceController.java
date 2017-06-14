package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Absence;
import dev.repository.AbsenceRepository;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

	@Autowired private AbsenceRepository absenceRepo;

	@GetMapping
	public List<Absence> listerabsences() {

	return this.absenceRepo.findAll();

	}
}	
