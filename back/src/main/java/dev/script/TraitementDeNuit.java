package dev.script;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import dev.entity.Absence;
import dev.entity.Collaborateur;
import dev.entity.Statut;
import dev.entity.Utilisateur;
import dev.repository.AbsenceRepository;
import dev.repository.UtilisateurRepository;
import dev.service.CalculAbsenceService;
import dev.service.CollaborateurService;

@Component
public class TraitementDeNuit {

	@Autowired AbsenceRepository absRepository;
	@Autowired UtilisateurRepository userRepository;
	@Autowired CalculAbsenceService calcAbs;
	@Autowired CollaborateurService collabServ;
	
	//Logger pour test
	private static final Logger log = LoggerFactory.getLogger(TraitementDeNuit.class);

	//La méthode qui exécute le script à 1 heure du matin tout les jours
    @Scheduled(cron = "0/5 * * * * ?") //Schedule pour test
    //@Scheduled(cron = "0 0 1 * * ?") //Schedule pour prod
    public void fetchData(){
    	
    	//Parametrage du MailSender
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	mailSender.setHost("smtp.gmail.com");
    	mailSender.setPort(25);
    	mailSender.setUsername("clever.institut.test@gmail.com");
    	mailSender.setPassword("formationdta");
    	Properties prop = new Properties();
    	prop.setProperty("mail.transport.protocol", "smtp");
    	prop.setProperty("mail.smtp.auth", "true");
    	prop.setProperty("mail.smtp.starttls.enable","true");
        prop.setProperty("mail.debug","true");
        prop.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        mailSender.setJavaMailProperties(prop);
    	SimpleMailMessage msg = new SimpleMailMessage();
    	
    	//Date pour comparaison
    	LocalDate ld = LocalDate.now();
    	
    	//Récupération des absences au statut INITIALE
    	List<Absence> listAbs =  absRepository.findByStatut(Statut.INITIALE);
		
    	//Le traitement de nuit
		for(Absence a: listAbs){
			
			//Récupération de l'utilisateur lié à l'absence
			Utilisateur u = userRepository.findById(a.getutilisateur().getId());
			
			//Si la date de demande<date du jour
			if(MethodeSurDate.dateEstPlusGrandeQue(a.getdateDebut(),ld)){
				
				//Si l'utilisateur à suffisament de congé restant
				if(calcAbs.calculeCongeRestantUtilisateur(u)>0){
					a.setStatut(Statut.EN_ATTENTE_VALIDATION); //On passe au statut EN_ATTENTE 
					log.info("decompte " + calcAbs.calculeCongeRestantUtilisateur(u));
					absRepository.saveAndFlush(a); //On sauvegarde
					
					msg.setFrom("clever.institut.test@gmail.com");
					msg.setTo("franc.lavaud@gmail.com");
					msg.setText("Salut toi !");
					
					mailSender.send(msg);
				}
				
				//Si l'utilisateur n'a pas suffisament de congé la demande est rejetée
				else{
					a.setStatut(Statut.REJETEE);
					absRepository.saveAndFlush(a);
				}
				
			}
			//Si la demande est faite le joure même ou plus tard que la date de début elle est rejetée
			else{
				a.setStatut(Statut.REJETEE);
				absRepository.saveAndFlush(a);
			}
		}
        
    }
    
    /**
     * Methode permettant de recupérer l'email du manager de l'utilisateur passer
     * en paramètre
     * 
     * @param u
     * @return
     */
    public String findEmailManager(Utilisateur u){
    	
    	List<Collaborateur> collabList=null;
		try {
			collabList = collabServ.listerCollaborateurs();
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
		
    	String matriculeUser=u.getMatriculeCollab();
    	String emailManager="";
    	
    	a: for(Collaborateur c: collabList){
    		for(String s:c.getSubalternes()){
    			if(s.equals(matriculeUser)){
    				emailManager = c.getEmail();
    				break a;
    			}
    		}
    	}
    	
    	return emailManager;
    }

}
