package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Integer>{

}
