package dev.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.entity.Collaborateur;

@Service
public class CollaborateurService {

	
	
	/* 
	 * Fonction récupérant les collaborateurs stockés sur serveur distant
	 * 		et les retournant sous forme de liste d'objets Collaborateur
	 */
	public List<Collaborateur> listerCollaborateurs() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://raw.githubusercontent.com/DiginamicFormation/ressources-atelier/master/users.json");
        
        return objectMapper.readValue(url, new TypeReference<ArrayList<Collaborateur>>() {});
        
	}
}
