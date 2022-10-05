package com.esprit.examen.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;

import io.swagger.annotations.Api;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {
		public class ProduitDTO {
		
			 Long idProduit;
			 String codeProduit;
			 String libelleProduit;
			 float prix;
			 Date dateCreation;
			 Date dateDerniereModification;
			
		}
	@Autowired
	IProduitService produitService;

	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
	
	}

	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}


	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p) {
		return  produitService.addProduit(p);
		
	}

	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit p) {
		return produitService.updateProduit(p);
	}


	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}

	
	 


}
