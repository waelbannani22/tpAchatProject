package com.esprit.examen.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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


import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.ReglementRepository;
import com.esprit.examen.repositories.StockRepository;


@ExtendWith(MockitoExtension.class)
public class ReglementServiceTestMock {
  
   @Mock
FactureRepository facturerepo;
  
   @InjectMocks
    FactureServiceImpl factureservice;
Facture s = new Facture( new Date(),  new Date(), false, null, null, null);
  @Mock
ReglementRepository reglementRepository;

  @InjectMocksReglementServiceImpl reglementservice;
Reglement R = new Reglement(22, 22, true, new Date());
@SuppressWarnings("serial")
ArrayList<Reglement> listereglements = new ArrayList<Reglement>() {
{
add( new Reglement(25, 25, true, new Date()));
add( new Reglement(24, 24, true, new Date()));
}
};
@Test
public void retrieveAllReglements() throws ParseException {
Mockito.when(reglementRepository.findAll()).thenReturn(listereglements);
List<Reglement> pr =reglementservice.retrieveAllReglements();
assertNotNull(pr);
@Test
public void addReglement() throws ParseException {
Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(R));
Reglement pr =reglementservice.retrieveReglement(2L);
Reglement R= reglementservice.addReglement(pr);
assertNotNull(R.getMontantPaye()); 
  assertNotNull(R.getMontantRestant());
  assertNotNull(R.getPayee());
  assertNotNull(R.getDateReglement());
  }
  @Test
public void retrieveReglement() throws ParseException {
Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(R));
  Reglement pr =reglementservice.retrieveReglement(2L);
assertNotNull(pr);
  }
   @Test
  public void retrieveReglementByFacture()throws ParseException {
    Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(R));
Mockito.when(facturerepo.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
    Facture f = factureservice.retrieveFacture(1l);
Reglement pr =reglementservice.retrieveReglement(2L);
    pr.setFacture(s);
}
