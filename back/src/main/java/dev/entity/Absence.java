package dev.entity;

import javax.persistence.*;


@Entity
public class Absence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id ;
	
	String dateDebut;
	String dateFin;

	@Enumerated(EnumType.STRING)
	TypeAbsence type;
	
	@Enumerated(EnumType.STRING)
	Statut statut;
	
	String motif;
	
	@ManyToOne
	Utilisateur utilisateur;

	public Absence(String dateDebut, String dateFin, TypeAbsence type, Statut statut, String motif,
			Utilisateur utilisateur) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
		this.statut = statut;
		this.motif = motif;
		this.utilisateur = utilisateur;
	}

	public Absence() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdateDebut() {
		return dateDebut;
	}

	public void setdateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getdateFin() {
		return dateFin;
	}

	public void setdateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public TypeAbsence getType() {
		return type;
	}

	public void setType(TypeAbsence type) {
		this.type = type;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Utilisateur getutilisateur() {
		return utilisateur;
	}

	public void setutilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



}
