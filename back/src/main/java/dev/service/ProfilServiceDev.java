package dev.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Absence;
import dev.entity.Collaborateur;
import dev.entity.JourFerie;
import dev.entity.Role;
import dev.entity.Statut;
import dev.entity.TypeAbsence;
import dev.entity.TypeJourFerie;
import dev.entity.Utilisateur;
import dev.repository.AbsenceRepository;
<<<<<<< HEAD
=======
import dev.repository.JourFerieRepository;
>>>>>>> USGDA017 - Traitement de nuit #20 - US en review - correction
import dev.repository.UtilisateurRepository;

@Service
public class ProfilServiceDev {

<<<<<<< HEAD
	@Autowired CollaborateurService collabServ;
	@Autowired UtilisateurRepository utilisateurRepo;
	@Autowired AbsenceRepository absenceRepo;
=======
	@Autowired CollaborateurService collabserv;
	@Autowired UtilisateurRepository utilisateurrepo;
	@Autowired AbsenceRepository absR;
	@Autowired JourFerieRepository jFR;
>>>>>>> USGDA017 - Traitement de nuit #20 - US en review - correction
	
	public void init() {

<<<<<<< HEAD
		absenceRepo.deleteAll();
		utilisateurRepo.deleteAll();
=======
		absR.deleteAll();
		utilisateurrepo.deleteAll();
		jFR.deleteAll();
>>>>>>> USGDA017 - Traitement de nuit #20 - US en review - correction

		List<Collaborateur> listcollab = collabServ.listerCollaborateurs();
		for (Collaborateur collaborateur : listcollab) {
			if(collaborateur == listcollab.get(0)) {
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.ADMIN));
			}else if (collaborateur == listcollab.get(1)){
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.MANAGER));
			}else {
<<<<<<< HEAD
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.COLLABORATEUR));
=======
				Utilisateur user = new Utilisateur(collaborateur.getMatricule(), null, Role.COLLABORATEUR);
				utilisateurrepo.save(user);
				absR.saveAndFlush(new Absence( LocalDate.parse("2017-06-20"), LocalDate.parse("2017-06-21"), TypeAbsence.getRandomTypeAbsence(), Statut.INITIALE, "",user));
>>>>>>> USGDA017 - Traitement de nuit #20 - US en review - correction
			}
			//return listcollab;
		}
		jFR.saveAndFlush(new JourFerie( LocalDate.parse("2017-06-20"),TypeJourFerie.FERIE, ""));
		jFR.saveAndFlush(new JourFerie( LocalDate.parse("2017-06-21"),TypeJourFerie.RTT_EMPLOYEUR, ""));
	}
	
}
