package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
public class Absence {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id ;
LocalDateTime debut;
LocalDateTime fin;
@Enumerated(EnumType.STRING)
TypeAbsence type;
@Enumerated(EnumType.STRING)
Statut statut;
String motif;
@ManyToOne
Utilisateur collab;

public Absence(LocalDateTime debut, LocalDateTime fin, TypeAbsence type, Statut statut, String motif,
		Utilisateur collab) {
	super();
	this.debut = debut;
	this.fin = fin;
	this.type = type;
	this.statut = statut;
	this.motif = motif;
	this.collab = collab;
}

public Absence() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public LocalDateTime getDebut() {
	return debut;
}

public void setDebut(LocalDateTime debut) {
	this.debut = debut;
}

public LocalDateTime getFin() {
	return fin;
}

public void setFin(LocalDateTime fin) {
	this.fin = fin;
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

public Utilisateur getCollab() {
	return collab;
}

public void setCollab(Utilisateur collab) {
	this.collab = collab;
}



}
