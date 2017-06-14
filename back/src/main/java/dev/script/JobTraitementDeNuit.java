package dev.script;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.entity.Absence;
import dev.entity.Statut;
import dev.repository.AbsenceRepository;

@Component
public class JobTraitementDeNuit implements Job {

	@Autowired AbsenceRepository absRepository;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		this.executeNow();

	}
	
	public void executeNow(){
		List<Absence> listAbs =  absRepository.findByStatut(Statut.INITIALE);
		listAbs.isEmpty();
	}

}
