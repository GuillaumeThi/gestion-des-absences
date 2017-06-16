package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.entity.TypeAbsence;

@Service
public class AbsenceService {

	
	/* 
	 * Fonction récupérant tous les types actifs de congés
	 */
	public List<String> listerTypesAbsence() {
		
		List<String> values = new ArrayList<>();
        TypeAbsence[] types =  TypeAbsence.values();        
        for (TypeAbsence type : types) {
        	
            if (type.isActif()){
            	
                values.add(type.getLibelle());
            }
        }
        return values;
	}
}
