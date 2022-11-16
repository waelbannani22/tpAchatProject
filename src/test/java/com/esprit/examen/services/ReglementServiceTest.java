
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
List<Reglement> reglements = (List<Reglement>) reglementservice.retrieveAllReglements();
int expected = reglements.size();
Reglement R = new Reglement(22, 22, false, Date1);
Reglement reglement = reglementservice.addReglement(R);
assertEquals(expected + 1, reglementservice.retrieveAllReglements().size());
reglementservice.retrieveReglement(reglement.getIdReglement());
}


    @Test
public void addReglement() throws ParseException {
   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   Date Date1 = dateFormat.parse("25/09/2000");
Reglement R = new Reglement(22, 22, false, Date1);
Reglement savedReglement= reglementservice.addReglement(R);
assertNotNull(savedReglement.getMontantPaye());
assertNotNull(savedReglement.getMontantRestant());
assertNotNull(savedReglement.getPayee());
assertNotNull(savedReglement.getDateReglement());
}

  @Test
public void retrieveReglement() throws ParseException {
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   Date Date1 = dateFormat.parse("25/09/2000");
   Long id =(long)0;
Reglement R = new Reglement(22, 22, false, Date1);

reglementservice.addReglement(R);
assertNull(reglementservice.retrieveReglement(id));
}
   @Test
  public void retrieveReglementByFacture()throws ParseException {
   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   Date dateNaissance = dateFormat.parse("25/09/2000");
    Facture s = new Facture(dateNaissance, dateNaissance, false, null, null, null);
     Date Date1 = dateFormat.parse("25/09/2000");
    Reglement R = new Reglement(22, 22, false, Date1);
    R.setFacture(s);
     assertNotNull(reglementRepository.retrieveReglementByFacture(s.getIdFacture()));
    }
  @Test
  public void  getChiffreAffaireEntreDeuxDate()throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   Date datestart = dateFormat.parse("20/09/2000");
     Date datefin = dateFormat.parse("29/09/2000");
    Date Date1 = dateFormat.parse("25/09/2000");
    Reglement R = new Reglement(22, 22, true, Date1);
}
