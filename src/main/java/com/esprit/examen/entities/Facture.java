package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Facture implements Serializable {
	public Facture(Date dateNaissance, Date dateNaissance2, boolean b, Object object, Object object2, Object object3) {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateCreationFacture;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModificationFacture;
	private Boolean archivee;
	@OneToMany(mappedBy = "facture")
	private Set<DetailFacture> detailsFacture;
    @ManyToOne
    @JsonIgnore
    private Fournisseur fournisseur;
    @OneToMany(mappedBy="facture")
    @JsonIgnore
    private Set<Reglement> reglements;

	public Facture(Date dateCreationFacture , Date dateDerniereModificationFacture , Boolean archivee, Set<DetailFacture> detailsFacture,Fournisseur fournisseur,Set<Reglement> reglements ) {
		super();
		this.dateCreationFacture = dateCreationFacture;
		this.dateDerniereModificationFacture = dateDerniereModificationFacture;
		this.archivee = archivee;
		this.fournisseur = fournisseur;
		this.detailsFacture =detailsFacture;
		this.reglements = reglements;

	}
	
}
