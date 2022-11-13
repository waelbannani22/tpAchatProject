package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;

@ExtendWith(MockitoExtension.class)
public class ProduitServiceMockTest {

    @Mock
	StockRepository stockrepo;
    @InjectMocks
    StockServiceImpl stockservice;
    Stock s = new Stock("stock test",10,100);	
	@Mock
	ProduitRepository produitrepo;
	@InjectMocks
     ProduitServiceImpl produitservice;
	Produit p =  new Produit("produitI", "produitII", (float) 2.5, new Date(),new Date());
	@SuppressWarnings("serial")
	ArrayList<Produit> listeproduits = new ArrayList<Produit>() {
	{
	add( new Produit("produitI", "produitII", (float) 2.5, new Date(),new Date()));
	add( new Produit("produit", "produitI", (float) 2, new Date(),new Date()));
	}
	};
	@Test
	@Order(2)
	 void  testretrieveAllProduits()  {
		Mockito.when(produitrepo.findAll()).thenReturn(listeproduits);
		List<Produit> pr =produitservice.retrieveAllProduits();
		assertNotNull(pr);
		
 	}
	@Test
	@Order(1)
	 void testAddProduit(){
		Mockito.when(produitrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
		Produit pr =produitservice.retrieveProduit(2L);		
		Produit produit= produitservice.addProduit(pr);
		assertNotNull(produit.getDateDerniereModification());
		assertEquals(produit.getPrix(),pr.getPrix());
		assertNotNull(produit.getCodeProduit());
		assertNotNull(produit.getLibelleProduit());
		produitservice.deleteProduit(produit.getIdProduit());
		
	}
	@Test
	@Order(6)
	 void testDeleteProduit()  {
		Mockito.when(produitrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
		Produit pr =produitservice.retrieveProduit(2L);
		produitservice.deleteProduit(pr.getIdProduit());
		assertNull(produitservice.retrieveProduit(pr.getIdProduit()));
	}
	@Test
	@Order(4)
	 void testretrieveProduit() 
	{
		Mockito.when(produitrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
		 
		Produit pr =produitservice.retrieveProduit(2L);
		assertNotNull(pr);
		
		
	}	
	@Test
	@Order(3)
	 void testupdateProduit( ) {
		Mockito.when(produitrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
		Produit pr =produitservice.retrieveProduit(2L);   
		pr.setLibelleProduit("produit3");
		assertThat(pr.getLibelleProduit()).isEqualTo("produit3");
			}
	@Test
	@Order(5)
	@Transactional
	 void testassignProduitToStock()   {
		Mockito.when(produitrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
		Mockito.when(stockrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
		Stock s = stockservice.retrieveStock(1l); 
		Produit pr =produitservice.retrieveProduit(2L);
		pr.setStock(s);
		Produit produit = produitservice.addProduit(pr);
 		assertThat(produit.getStock().getIdStock()).isEqualTo(s.getIdStock());

	}

}
