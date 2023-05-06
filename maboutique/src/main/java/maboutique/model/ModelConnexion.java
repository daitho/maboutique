package maboutique.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
import javax.inject.Named;

import maboutique.dao.jpa.DaoUtilisateur;
import maboutique.data.Utilisateur;
import maboutique.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class ModelConnexion implements Serializable {

	private String email;
	private String motDePasse;
	private Utilisateur utilisateurActif;
	@Inject
	private DaoUtilisateur daoUtilisateur;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Utilisateur getUtilisateurActif() {
		return utilisateurActif;
	}

	public String login() {
//		if (!email.isEmpty() && email.equals(motDePasse)) {
//			utilisateurActif = new Utilisateur();
//			UtilJsf.messageInfo("Connexion rÃ©ussie.");
//			return "/pages/home2?faces redirect=true";
//		} else
//			utilisateurActif = null;
////		FacesContext.getCurrentInstance().addMessage(null,
////		new FacesMessage("Identifiant ou mot de passe invalide.") );
//		UtilJsf.messageError("Identifiant ou mot de passe invalide.");
//		return "login";
		utilisateurActif = daoUtilisateur.authentifier(email, motDePasse);
		if (utilisateurActif != null) {
			UtilJsf.messageInfo("Connexion réussie.");
			email = null;
			motDePasse = null;
			return "home";
		} else {
			UtilJsf.messageError("Identifiant ou mot de passe invalide.");

			return "login";
		}
	}

	public String logout() {
//		utilisateurActif = null;
////		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vous avez Ã©tÃ© dÃ©connectÃ©"));
//		UtilJsf.messageInfo("Vous avez Ã©tÃ© dÃ©connectÃ©");
////		return "login";
//		return "/login2?faces redirect=true";
		// Mettre en commentaire car en rendant invalidÃ©, la vue /login2.xhtml n'a pas
		// pu Ãªtre restaurÃ©e.
		UtilJsf.sessionInvalidate();
		UtilJsf.messageInfo("Vous avez été déconnecté");
		return "login";
	}

	public boolean isLoggedIn() {
		return utilisateurActif != null;
	}

	public boolean isAdmin() {
		if (utilisateurActif != null && utilisateurActif.isAdmin() == true) {
			return true;
		} else {

			return false;
		}
	}
}
