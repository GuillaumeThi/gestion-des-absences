package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Collaborateur;
import dev.service.CollaborateurService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired private CollaborateurService collabserv;

	@GetMapping
	public Collaborateur Authentification (String email, String password) {

		List<Collaborateur> listcollab = collabserv.listerCollaborateurs();
		Collaborateur collaborateur = listcollab
				.stream().filter(p -> p.getEmail() == email).collect(Collectors.toList()).get(0);
		
		if(collaborateur == null){ return null;}
		else if (!collaborateur.getPassword().equals(DigestUtils.sha1Hex(password))) return null;
		else {return collaborateur;}
			
	}
}	
