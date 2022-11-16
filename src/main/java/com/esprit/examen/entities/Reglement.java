package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reglement implements Serializable{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idReglement;
private float montantPaye;
private float montantRestant;
private Boolean payee;
@Temporal(TemporalType.DATE)
private Date dateReglement;
@ManyToOne(cascade=CascadeType.ALL)
@JsonIgnore
private Facture facture;
public Reglement( float montantPaye, float montantRestant, Boolean payee, Date dateReglement) {
super();
this.montantPaye = montantPaye;
this.montantRestant = montantRestant;
this.payee = payee;
this.dateReglement = dateReglement;
}

}
