package com.esprit.examen.services;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.TpAchatProjectApplication;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@RunWith(SpringRunner.class)


public class OperateurServicelmplTest {

    @Mock
    private OperateurRepository operateurRepository;


    @InjectMocks
    OperateurServiceImpl operateurService;

    private Operateur operateur1 = new Operateur(1L,"test1","tes1","546125", null);
    private Operateur operateur2 = new Operateur(2L,"test2","test2","546125", null);

    @Test
    public void addOperateurTest() {
        when(operateurRepository.save(operateur1)).thenReturn(operateur1);
        assertNotNull(operateur1);

        Operateur persisted = operateurService.addOperateur(operateur1);
        assertEquals(operateur1, persisted);

        System.out.println("add operators works !");
    }

    @Test
    public void retrieveAllOperateursTest() {
        when(operateurRepository.findAll()).thenReturn(Stream
                .of(operateur1,operateur2)
                .collect(Collectors.toList()));

        assertEquals(2,operateurService.retrieveAllOperateurs().size());
        System.out.println("Retrieve all operators works !");
    }

    @Test
    public void UpdateOperateurTest() {
        when(operateurRepository.save(operateur1)).thenReturn(operateur1);
        assertNotNull(operateur1);
        assertEquals(operateur1, operateurService.updateOperateur(operateur1));
        System.out.println("Update operators works!");
    }

    @Test
    public void retrieveOperateurTest() {
        when(operateurRepository.findById(operateur1.getIdOperateur())).thenReturn(Optional.of(operateur1));
        assertEquals(operateur1, operateurService.retrieveOperateur(operateur1.getIdOperateur()));
        System.out.println("Retrieve operator by id works !");
    }


}