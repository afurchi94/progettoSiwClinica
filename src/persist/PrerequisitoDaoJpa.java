package persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import controllerTipologiaEsame.ControllerTipologiaEsame;
import model.Facade;
import model.Prerequisito;
import model.Risultato;
import model.TipologiaEsame;

public class PrerequisitoDaoJpa implements PrerequisitoDao {

	@Override
	public void save(EntityManager em, Prerequisito prerequisito) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prerequisito);
		tx.commit();

	}

	@Override
	public void delete(EntityManager em, Prerequisito prerequisito) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(prerequisito);
		tx.commit();
	}

	@Override
	public Prerequisito find(EntityManager em, Prerequisito prerequisito) {
		return em.find(Prerequisito.class, prerequisito);
	}

	@Override
	public void update(EntityManager em, Prerequisito prerequisito) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(prerequisito);
		tx.commit();
	}

}
