package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;




@ExtendWith(MockitoExtension.class)
public class FactureServiceMockTest {
	
	
	@InjectMocks
	FactureServiceImpl factureService;
	
	@Mock
	FactureRepository factureRepository;
	
	@Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
	
	Facture f = new Facture(new Date(),new Date(),false,null,null,null);
	
	ArrayList<Facture> factures = new ArrayList<Facture>(){
		

			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			{
				add(new Facture(new Date(),new Date(),false,null,null,null));
				add(new Facture(new Date(),new Date(),true,null,null,null));
			}
	};		
	@Test
	
	public void retrieveAllFacturesMock() {
		Mockito.when(factureRepository.findAll()).thenReturn(factures);
		
		//Facture f1 = factureService.retrieveFacture(f.getIdFacture());
		List<Facture> fac = factureService.retrieveAllFactures();
		assertNotNull(fac);
	}
	@Test
	public void addFacturesMock() {
		Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Facture fa = factureService.retrieveFacture(2L);
		factureService.cancelFacture(fa.getIdFacture());
		assertNull(factureService.retrieveFacture(fa.getIdFacture()));
		
	}
	@Test
	public void retrieveFactureMock() {
		Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Facture fa = factureService.retrieveFacture(2L);
		assertNotNull(fa);
		
	}
	@Test
	public void deleteFactureMock() {
		Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Facture fa = factureService.retrieveFacture(2L);
		factureService.cancelFacture(fa.getIdFacture());
		assertNull(factureService.retrieveFacture(fa.getIdFacture()));
		
	}
	

}
