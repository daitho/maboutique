package maboutique.dao.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import maboutique.data.Produit;
import maboutique.data.Utilisateur;

@Stateless
@LocalBean
public class DaoProduit {
	
	// Champs
		@PersistenceContext
		private EntityManager em;

		// Actions
		public int inserer(Produit produit) {
			em.persist(produit);
			em.flush();
			return produit.getId();
		}

		public void modifier(Produit produit) {
			em.merge(produit);
		}

		public void supprimer(int idProduit) {
			em.remove(em.getReference(Produit.class, idProduit));
		}

		public Produit retrouver(int idProduit) {
			return em.find(Produit.class, idProduit);
		}

		public List<Produit> listerTout() {
			var jpql = "SELECT p FROM Produit p ORDER BY p.id";
			var query = em.createQuery(jpql, Produit.class);
			return query.getResultList();
		}
		public List<Produit> listerCatalogue(Utilisateur vendeur) {
			var jpql = "SELECT p FROM Produit p WHERE p.statut='D' AND p.vendeur<>:vendeur "
					+ "ORDER BY p.nom";
			var query = em.createQuery(jpql, Produit.class);
			query.setParameter("vendeur", vendeur);
			return query.getResultList();
		}


}
