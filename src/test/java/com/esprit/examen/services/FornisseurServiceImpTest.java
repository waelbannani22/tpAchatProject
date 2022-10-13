
package com.esprit.examen.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
@RunWith(SpringRunner.class)
@SpringBootTest

public class FornisseurServiceImpTest {
	@Autowired
	IFournisseurService fornisseurservice;
	@Test
	public void  retrieveAllFournisseurs() throws ParseException {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fornisseurservice.retrieveAllFournisseurs();
		int expected = fournisseurs.size();
		Fournisseur f = new Fournisseur();
		Fournisseur fournisseur = fornisseurservice.addFournisseur(f);
		assertEquals(expected + 1, fornisseurservice.retrieveAllFournisseurs().size());
		fornisseurservice.deleteFournisseur(fournisseur.getIdFournisseur());
 	}
	@Test
	public void addFournisseur() throws ParseException {
		Fournisseur f = new Fournisseur( "test2", "code", CategorieFournisseur.ORDINAIRE, null);
		Fournisseur fornisseur = fornisseurservice.addFournisseur(f);
		System.out.print("fournisseur "+fornisseur);
		assertNotNull(fornisseur.getIdFournisseur());
		assertNotNull(fornisseur.getCode());
		assertNotNull(fornisseur.getLibelle());
		assertNotNull(fornisseur.getCategorieFournisseur());
		fornisseurservice.deleteFournisseur(fornisseur.getIdFournisseur());	
	}
	@Test
	public void deleteFournisseur() throws ParseException {
		Fournisseur f = new Fournisseur();
		Fournisseur savedFournisseur= fornisseurservice.addFournisseur(f);
		fornisseurservice.deleteFournisseur(savedFournisseur.getIdFournisseur());
		assertNull(fornisseurservice.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
	}
	@Test
	public void retrieveFournisseur() throws ParseException
	{
			Long id =(long)0;
			Fournisseur f = new Fournisseur();
			fornisseurservice.addFournisseur(f);
			assertNull(fornisseurservice.retrieveFournisseur(id));				
	}	
	@Test
	public void updateFournisseur( )  throws ParseException{
		Fournisseur f = new Fournisseur();	
		f.setLibelle("fournisseur3");
		assertThat(f.getLibelle()).isEqualTo("fournisseur3");
			}
	@Test
	@Transactional

	public void assignSecteurActiviteToFournisseur()  throws ParseException {
		Fournisseur f = new Fournisseur();	
		Fournisseur fournisseur = fornisseurservice.addFournisseur(f);
 

	}
}

