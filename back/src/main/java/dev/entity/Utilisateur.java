package dev.entity;



import javax.persistence.*;

@Entity
public class Utilisateur {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String matriculeCollab;
@ManyToOne 
Absence absences;
@Enumerated(EnumType.STRING)
Role role;

public Utilisateur(String matriculeCollab, Absence absences, Role role) {
	super();
	this.matriculeCollab = matriculeCollab;
	this.absences = absences;
	this.role = role;
}

public Utilisateur() {
	super();

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMatriculeCollab() {
	return matriculeCollab;
}

public void setMatriculeCollab(String matriculeCollab) {
	this.matriculeCollab = matriculeCollab;
}

public Absence getAbsences() {
	return absences;
}

public void setAbsences(Absence absences) {
	this.absences = absences;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}



}
