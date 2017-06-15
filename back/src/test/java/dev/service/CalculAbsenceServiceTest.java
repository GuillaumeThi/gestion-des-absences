package dev.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = CalculAbsenceService.class)
//@SpringBootConfiguration 
@RunWith(SpringRunner.class)
@DataJpaTest
@EntityScan("dev.entity")
@EnableJpaRepositories("dev.repository")
public class CalculAbsenceServiceTest {
	
	@Autowired private CalculAbsenceService cas;
	
	@Test
	public void test(){
		LocalDate ldDebut = LocalDate.of(2017, 6, 16);
		LocalDate ldFin = LocalDate.of(2017, 6, 23);
		assertThat(cas.getJoursAbsenceEffectifs(ldDebut, ldFin),equalTo(5));
	}
}
