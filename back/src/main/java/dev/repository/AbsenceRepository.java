package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Absence;
import dev.entity.Statut;

public interface AbsenceRepository extends JpaRepository<Absence, Integer>{
	List<Absence> findByStatut(Statut statut);
}
