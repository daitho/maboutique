package maboutique.data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotBlank( message="Le nom doit être renseigné")
	@Min(value  = 0, message="Le prix ne doit pas être inférieur à zéro")
	private String nom;

	@NotBlank( message="Le prix doit être renseigné")
	@Size(min=0, message="Le prix ne doit pas être inférieur à zéro" )
	private double prix;

	@NotBlank( message="Le statut doit être renseigné")
	@Pattern(regexp = "[DCV]", message="Le statut doit contenir l'un des caractères D, C ou V")
	private String statut;

	//uni-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="idcategorie")
	@NotBlank( message="La categorie doit être indiquée")
	private Categorie categorie;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idacheteur")
	private Utilisateur acheteur;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idvendeur")
	@NotBlank( message="Le vendeur doit être indiquée")
	private Utilisateur vendeur;
	
	private int quantite;

	public Produit() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Utilisateur getAcheteur() {
		return this.acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public Utilisateur getVendeur() {
		return this.vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	

}