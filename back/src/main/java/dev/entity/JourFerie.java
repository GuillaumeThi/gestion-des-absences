package dev.entity;


import javax.persistence.*;

@Entity
public class JourFerie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String date;
	
	@Enumerated(EnumType.STRING)
	TypeJourFerie type;
	
	String commentaire;

	public JourFerie(String date, TypeJourFerie type, String commentaire) {
		this.date = date;
		this.type = type;
		this.commentaire = commentaire;
	}

	public JourFerie() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TypeJourFerie getType() {
		return type;
	}

	public void setType(TypeJourFerie type) {
		this.type = type;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



}
