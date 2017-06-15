package dev.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import dev.entity.Absence;
import dev.entity.JourFerie;
import dev.entity.Utilisateur;
import dev.repository.AbsenceRepository;
import dev.repository.JourFerieRepository;
import dev.script.MethodeSurDate;


@Service
/**
 * Permet de calculer le nombre d'absence restant à un utilisateur
 * @author Franc
 *
 */
public class CalculAbsenceService {
	
	@Autowired private JourFerieRepository jfRepository;
	@Autowired private AbsenceRepository absenceRepository;

	
	/**
	 * Permet de calculer le nombre effectif de jour-absence sur une periode données
	 * en décomptant les week-end et jour férié
	 * 
	 * @param dateDebut
	 * @param datFin
	 */
	public int getJoursAbsenceEffectifs(LocalDate dateDebut, LocalDate dateFin){
		int nombrejourEffectif=0;
		LocalDate ld = dateDebut;
		
		while(MethodeSurDate.dateEstPlusGrandeOuEgal(dateFin, ld)){
			if(ld.getDayOfWeek()!=DayOfWeek.SATURDAY && ld.getDayOfWeek()!=DayOfWeek.SUNDAY && !this.estFerie(ld)){		
				nombrejourEffectif++;
			}
			ld=ld.plusDays(1);
		}
		
		return nombrejourEffectif;
	}
	
	/**
	 * Calcul le nombre de congé payé restant à un utilisateur
	 * @param u
	 * @return
	 */
	public int calculeCongeRestantUtilisateur(Utilisateur u){
		
		List<Absence> listAbsDeUtilisateur = absenceRepository.findByUtilisateurId(u.getId());
		int decompteDeJour = 25;
		
		for(Absence a:listAbsDeUtilisateur){
			decompteDeJour-=getJoursAbsenceEffectifs(a.getdateDebut(), a.getdateFin());
		}
		
		return decompteDeJour;
	}
	
	/**
	 * Calcul le nombre de RTT Employeur restant à un utilisateur
	 * @param u
	 * @return
	 */
	public int calculeRttEmployeurRestantUtilisateur(Utilisateur u){
		return 0;
	}
	
	/**
	 * Calcul le nombre de RTT Employe restant à un utilisateur
	 * @param u
	 * @return
	 */
	public int calculeRttEmployeRestantUtilisateur(Utilisateur u){
		return 0;
	}
	
	private boolean estFerie(LocalDate date){
		List<JourFerie> listJourFerie = jfRepository.findAll();
		
		for(JourFerie jf:listJourFerie){
			if(date.equals(jf.getDate()) ){
				return true;
			}
		}
		
		
		return false;
	}
}
