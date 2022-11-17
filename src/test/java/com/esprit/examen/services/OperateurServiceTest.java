package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceTest {
	@Autowired
	IOperateurService opservice;
	@Test
	public void retrieveAllOperateurs() {
		
		
		List<Operateur> produits = (List<Operateur>) opservice.retrieveAllOperateurs();
		int expected = produits.size();
		Operateur c = new Operateur("test","test","test");
		Operateur op = opservice.addOperateur(c);
		assertEquals(expected + 1, opservice.retrieveAllOperateurs().size());
		opservice.deleteOperateur(op.getIdOperateur());
	}

	@Test
	public void addOperateur() {
		Operateur c = new Operateur("test","test","test");
		Operateur savedop= opservice.addOperateur(c);
		assertNotNull(savedop);
	
	}

	@Test
	public void deleteOperateur() {
		Operateur c = new Operateur("test","test","test");
		Operateur savedop= opservice.addOperateur(c);
		opservice.deleteOperateur(savedop.getIdOperateur());
		assertNull(opservice.retrieveOperateur(savedop.getIdOperateur()));
	}

	@Test
	public void updateOperateur() {
		Operateur c = new Operateur("test","test","test");
		c.setNom("test3");
		assertThat(c.getNom()).isEqualTo("test3");
	}

	@Test
	public void retrieveOperateur() {
		Operateur c = new Operateur("test", "test","test");
		opservice.addOperateur(c);
		assertNull(opservice.retrieveOperateur(c.getIdOperateur()));	
	}

}
