package dev.entity;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
public class JourFerie {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
LocalDate date;
@Enumerated(EnumType.STRING)
TypeJourFerie type;
String commentaire;
}
