package dev.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import dev.entity.Collaborateur;
import dev.entity.Role;
import dev.entity.Utilisateur;
import dev.repository.UtilisateurRepository;

@Service
public class ProfilServiceDev implements ProfilService {

	@Autowired CollaborateurService collabserv;
	@Autowired UtilisateurRepository utilisateurrepo;
	
	
	@Override
	public void init() {
		utilisateurrepo.deleteAll();
		try {
			List<Collaborateur> listcollab = collabserv.listerCollaborateurs();
			for (Collaborateur collaborateur : listcollab) {
				if(collaborateur == listcollab.get(0)) {
					utilisateurrepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.ADMIN));
				}else if (collaborateur == listcollab.get(1)){
					utilisateurrepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.MANAGER));
				}else {
					utilisateurrepo.save(new Utilisateur(collaborateur.getMatricule(), null, Role.COLLABORATEUR));
				}
				//return listcollab;
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
