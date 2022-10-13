package com.esprit.examen.services;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
	@Autowired
	IFactureService factureService;
	
	
	@Test
	public void testAddFacture()throws ParseException  {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		SimpleDateFormat dateFormat=null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(dateNaissance, dateNaissance, false, null, null, null);
     	Facture savedStock= factureService.addFacture(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		//assertNotNull(savedStock.getLibelleStock());
		factureService.cancelFacture(savedStock.getIdFacture());
		
	} 
	
	@Test
	public void testCancelFacture()throws ParseException {
		
		
		SimpleDateFormat dateFormat=null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(dateNaissance, dateNaissance, false, null, null, null);
     	Facture savedStock= factureService.addFacture(s);
		
		Facture s1 = factureService.retrieveFacture(savedStock.getIdFacture());
     	factureService.cancelFacture(savedStock.getIdFacture());
     	assertNotEquals(s1, savedStock);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		//assertNotNull(savedStock.getLibelleStock());
		//factureService.cancelFacture(savedStock.getIdFacture());
		
	} 
	@Test
	public void testretriveFacture()throws ParseException {
		
		
		SimpleDateFormat dateFormat=null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(dateNaissance, dateNaissance, false, null, null, null);
     	Facture savedStock= factureService.addFacture(s);
		
		
     	//factureService.cancelFacture(savedStock.getIdFacture());
     	assertEquals(s, savedStock);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		//assertNotNull(savedStock.getLibelleStock());
		//factureService.cancelFacture(savedStock.getIdFacture());
		
	} 
}
