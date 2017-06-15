package dev.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.jpa.event.internal.jpa.ListenerCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import dev.entity.Collaborateur;
import dev.service.CollaborateurService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired private CollaborateurService collabserv;

	@GetMapping
	public Collaborateur Authentification (String email, String password) {
		try {
			List<Collaborateur> listcollab = collabserv.listerCollaborateurs();
			Collaborateur collaborateur = listcollab
					.stream().filter(p -> p.getEmail() == email).collect(Collectors.toList()).get(0);
			
			if(collaborateur == null){ return null;}
			else if (!collaborateur.getPassword().equals(DigestUtils.sha1Hex(password))) return null;
			else {
				return collaborateur;
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
		
		
		
	return null;
	}
}	
