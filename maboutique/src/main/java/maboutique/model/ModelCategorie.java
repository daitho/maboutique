package maboutique.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import maboutique.dao.jpa.DaoCategorie;
import maboutique.data.Categorie;
import maboutique.data.Utilisateur;
import maboutique.util.UtilJsf;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class ModelCategorie implements Serializable {

	// Champs
	private List<Categorie> liste;
	
	private Categorie courant;
	@Inject
	private DaoCategorie daoCategorie;

	public List<Categorie> getListe() {
		if (liste == null) {
			liste = daoCategorie.listerTout();
		}
		return liste;
	}

	public Categorie getCourant() {
		if (courant == null) {
			courant = new Categorie();
		}
		return courant;
	}

	// Actions
	public String actualiserCourant() {
		if (courant != null) {
			courant = daoCategorie.retrouver(courant.getId());
			if (courant == null) {
				UtilJsf.messageError("La catégorie demandée n'existe pas");
				return "liste";
			}
		}
		return null;
	}

	public String validerMiseAJour() {
		if ( courant.getId() == null ) {
		daoCategorie.inserer( courant );
		} else {
		daoCategorie.modifier( courant );
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
		}

	public String supprimer(Utilisateur item) {
		daoCategorie.supprimer(item.getId());
		liste = null;
		UtilJsf.messageInfo("Suppression effectuée avec succès.");
		return "liste";
	}

}
