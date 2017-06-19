package dev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Absence;
import dev.repository.AbsenceRepository;
import dev.service.AbsenceService;
import dev.service.CalculAbsenceService;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

	@Autowired private AbsenceRepository absenceRepo;
	@Autowired private AbsenceService absenceService;
	
	@Autowired private CalculAbsenceService compteurService;

	@GetMapping
	public Map<String, Object> listerAbsences(@PathParam(value="matricule") String matricule) {
		System.out.println(matricule);
		Map<String, Object> map = new HashMap<>();
		map.put("absences", this.absenceRepo.findAll());
//		map.put("conges-payes", this.compteurService.calculeCongeRestantUtilisateur());
//		map.put("RTT", this.compteurService.calculeCongeRestantUtilisateur());
		return map;
	}
	
	@GetMapping(path="/nouvelle-demande")
	public List<String> listerTypesAbsence() {

		return this.absenceService.listerTypesAbsence();
	}
	
//	@GetMapping(path="/compteur")
//	public Integer getCompteursConges() {
//
//		return this.compteurService.calculeCongeRestantUtilisateur(u, typeAbsence);
//	}
}	
