package maboutique.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import maboutique.dao.jpa.DaoProduit;
import maboutique.data.Produit;
import maboutique.util.UtilJsf;


@Named
@SessionScoped
@SuppressWarnings("serial")
@ManagedBean(value = "session")
public class ModelPanier implements Serializable{
	
	@Inject
	private ModelConnexion modelConnexion;
	@Inject
	private DaoProduit daoProduit;
	//@Inject
	//private DaoHistoriqueAchat daoHistoriqueAchat;
	private double total;
	private List<Produit> panier = new ArrayList<Produit>();

	public List<Produit> getPanier() {
		return panier;
	}
	
	public String valider()
	{
		for (Produit produit : panier) {
			produit.setStatut("C");
			produit.setAcheteur(modelConnexion.getUtilisateurActif());
			daoProduit.modifier(produit);
		}
		panier.clear();
		UtilJsf.messageInfo( "Votre commande a bien été enregistrée." );
		return "home";
	}
	
	
	public double getTotal(){
		total = 0.0;
		for(Produit  p : panier) {
			total+=p.getPrix();
		}
		return total;
	}
	
	public String setTotal() {
		total = getTotal();
		System.out.println("total="+total);
		return null;
	}
	public String supprimer(Produit p) {
		panier.remove(p);
		return null;
	}
	
	// Classe auxiliaire
//
//		public void setTotal(float total) {
//		this.total = total;
//	}
	
	

	public static class PanierAvecQuantité {
		
		// Champs
		private Produit	produit;
		private int	quantité;
			
		// Constructeur
		public PanierAvecQuantité(Produit produit, int quantité) {
			this.produit = produit;
			this.quantité = quantité;
		}

		public Produit getProduit() {
			return produit;
		}

		public void setProduit(Produit produit) {
			this.produit = produit;
		}

		public int getQuantité() {
			return quantité;
		}

		public void setQuantité(int quantité) {
			this.quantité = quantité;
		}
			
		// Getters & Setters
	}
}
