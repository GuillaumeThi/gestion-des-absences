package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Absence;
import dev.repository.AbsenceRepository;
import dev.service.AbsenceService;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

	@Autowired private AbsenceRepository absenceRepo;
	@Autowired private AbsenceService absenceService;

	@GetMapping
	public List<Absence> listerAbsences() {

		return this.absenceRepo.findAll();
	}
	
	@GetMapping(path="/nouvelle-demande")
	public List<String> listerTypesAbsence() {

		return this.absenceService.listerTypesAbsence();
	}
}	
