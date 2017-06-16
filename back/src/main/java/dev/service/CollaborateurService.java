package dev.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.entity.Collaborateur;

@Service
public class CollaborateurService {

	
	/* 
	 * Fonction récupérant les collaborateurs stockés sur serveur distant
	 * 		et les retournant sous forme de liste d'objets Collaborateur
	 */
	public List<Collaborateur> listerCollaborateurs()  {
		
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			
			URL url = new URL("https://raw.githubusercontent.com/DiginamicFormation/ressources-atelier/master/users.json");
			return objectMapper.readValue(url, new TypeReference<ArrayList<Collaborateur>>() {});
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
        
	}
}
