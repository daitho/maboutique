//package maboutique.dao.jpa;
//
//import java.util.List;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import maboutique.data.Historiqueachat;
//import maboutique.model.ModelConnexion;
//
//@Stateless
//@LocalBean
//public class DaoHistoriqueAchat {
//	// Champs
//	@PersistenceContext
//	private EntityManager em;
//
//	@Inject
//	private ModelConnexion modelConnexion;
//	// Actions
//	public int inserer(Historiqueachat croduit) {
//		em.persist(croduit);
//		em.flush();
//		return croduit.getId();
//	}
//
//	public void modifier(Historiqueachat croduit) {
//		em.merge(croduit);
//	}
//
//	public void supprimer(int idHistoriqueAchat) {
//		em.remove(em.getReference(Historiqueachat.class, idHistoriqueAchat));
//	}
//
//	public Historiqueachat retrouver(int idHistoriqueachat) {
//		return em.find(Historiqueachat.class, idHistoriqueachat);
//	}
//
//	public List<Historiqueachat> listerTout() {
//		var jpql = "SELECT p FROM Historiqueachat p WHERE p.utilisateur.id=:courant ORDER BY p.id";
//		var query = em.createQuery(jpql, Historiqueachat.class);
//		query.setParameter("courant", modelConnexion.getUtilisateurActif().getId());
//		return query.getResultList();
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
