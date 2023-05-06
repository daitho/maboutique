package maboutique.data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private boolean admin;

	@NotBlank( message="L'adresse email doit être renseignée")
	@Email( message="L'adresse e mail n'est pas valide.")
	private String email;

	@NotBlank( message="Le mot de passe doit être renseigné")
	@Size(min=5, message="Le mot d passe doit avoir au moins 5 caractères")
	@Size(max=50, message="Le mot d passe doit avoir au plus 50")
	private String motdepasse;

	@NotBlank( message="Le nom doit être renseigné")
	@Size(max=50, message="Valeur trop longue pour le nom : 50 car. maxi" )
	private String nom;

	@NotBlank( message="Le prénom doit être renseigné")
	@Size(max=50, message="Valeur trop longue pour le nom : 50 car. maxi" )
	private String prenom;

	public Utilisateur() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motdepasse;
	}

	public void setMotDePasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}

}