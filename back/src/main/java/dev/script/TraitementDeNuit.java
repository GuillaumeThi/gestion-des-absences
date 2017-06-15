package dev.script;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.entity.Absence;
import dev.entity.Statut;
import dev.repository.AbsenceRepository;

@Component
public class TraitementDeNuit {

@Autowired AbsenceRepository absRepository;
	
	private static final Logger log = LoggerFactory.getLogger(TraitementDeNuit.class);

   // @Scheduled(cron = "0/5 * * * * ?")
    public void fetchData() {
    	List<Absence> listAbs =  absRepository.findByStatut(Statut.INITIALE);
		listAbs.isEmpty();
		for(Absence a: listAbs){
			log.info("hello "+ a.getStatut().toString());
		}
        
    }

}
