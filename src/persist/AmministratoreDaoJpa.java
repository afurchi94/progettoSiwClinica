
package persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Amministratore;

public class AmministratoreDaoJpa implements AmministratoreDao {

	@Override
	public void save(EntityManager em, Amministratore amministratore) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(amministratore);
		tx.commit();

	}

	@Override
	public void delete(EntityManager em, Amministratore amministratore) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(amministratore);
		tx.commit();

	}
	//mi puzza visto che la classe è singleton.
	@Override
	public Amministratore find(EntityManager em, Amministratore amministratore) {
		return em.find(amministratore.getClass(), amministratore.getUsername());
	}

	@Override
	public void update(EntityManager em, Amministratore amministratore) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(amministratore);
		tx.commit();
	}
}
