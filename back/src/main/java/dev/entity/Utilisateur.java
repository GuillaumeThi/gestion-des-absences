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

}
