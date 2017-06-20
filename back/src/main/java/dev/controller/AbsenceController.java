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
import dev.entity.TypeAbsence;
import dev.repository.AbsenceRepository;
import dev.service.AbsenceService;
import dev.service.CalculAbsenceService;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

	@Autowired private AbsenceRepository absenceRepo;
	@Autowired private AbsenceService absenceService;
	
	@Autowired private CalculAbsenceService compteurService;
	
	@GetMapping(path="/total")
	public List<Absence> listerTotalAbsences() {
		return this.absenceRepo.findAll();
	}

	@GetMapping(path="/total")
    public List<Absence> listerTotalAbsences() {
        return this.absenceRepo.findAll();
    }
	
	@GetMapping
	public Map<String, Object> listerAbsences(@PathParam(value="matricule") String matricule) {
		Map<String, Object> map = new HashMap<>();
		map.put("absences", this.absenceRepo.findAll());
		map.put("congesPayes", this.compteurService.calculeCongeRestantUtilisateur(matricule, TypeAbsence.CONGE_PAYE.toString()));
		map.put("RTT", this.compteurService.calculeCongeRestantUtilisateur(matricule, TypeAbsence.RTT.toString()));
		return map;
	}
	
	@GetMapping(path="/nouvelle-demande")
	public List<String> listerTypesAbsence() {

		return this.absenceService.listerTypesAbsence();
	}
	
}	
