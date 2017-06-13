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
}
