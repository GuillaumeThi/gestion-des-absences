package dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Collaborateur;
import dev.entity.Role;
import dev.entity.Utilisateur;
import dev.repository.UtilisateurRepository;

@Service
public class InitService{

	@Autowired CollaborateurService collabserv;
	@Autowired UtilisateurRepository utilisateurrepo;
	
	
	
	public void init() {

		utilisateurrepo.deleteAll();

		List<Collaborateur> listcollab = collabserv.listerCollaborateurs();
		for (Collaborateur collaborateur : listcollab) {
			if(collaborateur == listcollab.get(0)) {
				utilisateurrepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.ADMIN));
			}else if (collaborateur == listcollab.get(1)){
				utilisateurrepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.MANAGER));
			}else {
				utilisateurrepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.COLLABORATEUR));
			}
		}
	}
}
