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
import dev.repository.JourFerieRepository;
import dev.repository.UtilisateurRepository;

@Service
public class ProfilServiceDev {

	@Autowired CollaborateurService collabserv;
	@Autowired UtilisateurRepository utilisateurrepo;
	@Autowired AbsenceRepository absR;
	@Autowired JourFerieRepository jFR;

	public void init() {

		absR.deleteAll();
		utilisateurrepo.deleteAll();
		jFR.deleteAll();

		List<Collaborateur> listcollab = collabServ.listerCollaborateurs();
		for (Collaborateur collaborateur : listcollab) {
			if(collaborateur == listcollab.get(0)) {
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.ADMIN));
			}else if (collaborateur == listcollab.get(1)){
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.MANAGER));
			}else {

				Utilisateur user = new Utilisateur(collaborateur.getMatricule(), null, Role.COLLABORATEUR);
				utilisateurrepo.save(user);
				absR.saveAndFlush(new Absence( LocalDate.parse("2017-06-20"), LocalDate.parse("2017-06-21"), TypeAbsence.getRandomTypeAbsence(), Statut.INITIALE, "",user));
			}
			//return listcollab;
		}
		jFR.saveAndFlush(new JourFerie( LocalDate.parse("2017-06-20"),TypeJourFerie.FERIE, ""));
		jFR.saveAndFlush(new JourFerie( LocalDate.parse("2017-06-21"),TypeJourFerie.RTT_EMPLOYEUR, ""));
	}
	
}
