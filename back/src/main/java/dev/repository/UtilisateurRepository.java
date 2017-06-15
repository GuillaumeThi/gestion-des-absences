package dev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	//Permet de chercher les utilisateurs par ID
	Utilisateur findById(int Id);


	List<Utilisateur> findByMatriculeCollab(String matriculeCollab);
}
