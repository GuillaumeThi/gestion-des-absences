package dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Collaborateur;
import dev.entity.Role;
import dev.entity.Utilisateur;
import dev.repository.AbsenceRepository;
import dev.repository.UtilisateurRepository;

@Service
public class ProfilServiceDev {

	@Autowired CollaborateurService collabServ;
	@Autowired UtilisateurRepository utilisateurRepo;
	@Autowired AbsenceRepository absenceRepo;
	
	public void init() {

		absenceRepo.deleteAll();
		utilisateurRepo.deleteAll();

		List<Collaborateur> listcollab = collabServ.listerCollaborateurs();
		for (Collaborateur collaborateur : listcollab) {
			if(collaborateur == listcollab.get(0)) {
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.ADMIN));
			}else if (collaborateur == listcollab.get(1)){
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.MANAGER));
			}else {
				utilisateurRepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.COLLABORATEUR));
			}
		}
	}
}
