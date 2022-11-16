
package com.esprit.examen.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ReglementRepository;
@RunWith(SpringRunner.class)
@SpringBootTest

public class ReglementServiceTest {
@Autowired
IReglementService reglementservice;
  @Autowired
ReglementRepository reglementRepository;
@Test
public void retrieveAllReglements() throws ParseException {
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date Date1 = dateFormat.parse("25/09/2000");
Reglement R = new Reglement(22, 22, false, Date1);
  }
  
