package dev.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import dev.entity.Collaborateur;
import dev.entity.Role;

public class ProfilServiceDev implements ProfilService {

	@Autowired CollaborateurService collabserv;
	
	
	@Override
	public void init() {
		try {
			List<Collaborateur> listcollab = collabserv.listerCollaborateurs();
			for (Collaborateur collaborateur : listcollab) {
				if(collaborateur == listcollab.get(0)) {
					collaborateur.setProfil(Role.ADMIN);
				}else if (collaborateur == listcollab.get(1)){
					collaborateur.setProfil(Role.MANAGER);
				}else {
					collaborateur.setProfil(Role.COLLABORATEUR);
				}
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
