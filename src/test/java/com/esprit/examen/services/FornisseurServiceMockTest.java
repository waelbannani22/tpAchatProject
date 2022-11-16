package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.repositories.StockRepository;
@ExtendWith(MockitoExtension.class)

public class FornisseurServiceMockTest {

    @Mock
	SecteurActiviteRepository secteurrepo;
    @InjectMocks
    SecteurActiviteServiceImpl secteurservice;
    /*
    SecteurActivite s = new SecteurActivite("test","test");	
	@SuppressWarnings("serial")

	Set<SecteurActivite> listesectuer =  {
	{
	add(new SecteurActivite( "test15", "code15")),

	add( new SecteurActivite( "test51", "code21")),

	}
	};
	*/
	@Mock
	FournisseurRepository fournisseurrepo;
	@InjectMocks
     FournisseurServiceImpl fournisseurservice;
	Fournisseur f = new Fournisseur( "test2", "code", CategorieFournisseur.ORDINAIRE, null);
	@SuppressWarnings("serial")
	ArrayList<Fournisseur> listeFournisseur = new ArrayList<Fournisseur>() {
	{
	add(new Fournisseur( "test2", "code", CategorieFournisseur.ORDINAIRE, null));

	add( new Fournisseur( "test5", "code2", CategorieFournisseur.ORDINAIRE, null)
);
	}
	};
	
	
	
	@Test
	public void  retrieveAllFournisseurs() throws ParseException {
		Mockito.when(fournisseurrepo.findAll()).thenReturn(listeFournisseur);
		List<Fournisseur> pr =fournisseurservice.retrieveAllFournisseurs();
		assertNotNull(pr);
 	}
	@Test
	public void addFournisseur() throws ParseException {
		Mockito.when(fournisseurrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Fournisseur pr =fournisseurservice.retrieveFournisseur(2L);		
		Fournisseur fournisseur= fournisseurservice.addFournisseur(pr);
	
		assertNotNull(fournisseur);
		fournisseurservice.deleteFournisseur(fournisseur.getIdFournisseur());
	}
	@Test
	public void deleteFournisseur() throws ParseException {
		Mockito.when(fournisseurrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Fournisseur pr =fournisseurservice.retrieveFournisseur(2L);
		fournisseurservice.deleteFournisseur(pr.getIdFournisseur());
		assertNull(fournisseurservice.retrieveFournisseur(pr.getIdFournisseur()));
	}
	@Test
	public void retrieveFournisseur() throws ParseException
	{
		Mockito.when(fournisseurrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		 
		Fournisseur pr =fournisseurservice.retrieveFournisseur(2L);
		assertNotNull(pr);
		
		
	}	
	@Test
	public void updateFournisseur( )  throws ParseException{
		Mockito.when(fournisseurrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Fournisseur pr =fournisseurservice.retrieveFournisseur(2L);   
		pr.setCode("code3");
		assertThat(pr.getCode()).isEqualTo("code3");
		
			}
	@Test
	@Transactional

	public void assignSecteurActiviteToFournisseur()  throws ParseException {
		/*
		Mockito.when(fournisseurrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Mockito.when(secteurrepo.findAllById(Mockito.anyList())).thenReturn(listesectuer);
		SecteurActivite s = secteurservice.retrieveSecteurActivite(1l); 
		Fournisseur pr =fournisseurservice.retrieveFournisseur(2L);
		pr.setSecteurActivites(listesectuer);
		Produit produit = produitservice.addProduit(pr);
 		assertThat(produit.getStock().getIdStock()).isEqualTo(s.getIdStock());
 		*/

	}
}

