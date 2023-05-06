//package maboutique.data;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//
//
///**
// * The persistent class for the historiqueachat database table.
// * 
// */
//@Entity
//@NamedQuery(name="Historiqueachat.findAll", query="SELECT h FROM Historiqueachat h")
//public class Historiqueachat implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer id;
//
//	private Integer quantite;
//
//	//bi-directional many-to-one association to Produit
//	@ManyToOne
//	@JoinColumn(name="idproduit")
//	private Produit produit;
//
//	//bi-directional many-to-one association to Utilisateur
//	@ManyToOne
//	@JoinColumn(name="idacheteur")
//	private Utilisateur utilisateur;
//
//	public Historiqueachat() {
//	}
//
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getQuantite() {
//		return this.quantite;
//	}
//
//	public void setQuantite(Integer quantite) {
//		this.quantite = quantite;
//	}
//
//	public Produit getProduit() {
//		return this.produit;
//	}
//
//	public void setProduit(Produit produit) {
//		this.produit = produit;
//	}
//
//	public Utilisateur getUtilisateur() {
//		return this.utilisateur;
//	}
//
//	public void setUtilisateur(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}
//
//}