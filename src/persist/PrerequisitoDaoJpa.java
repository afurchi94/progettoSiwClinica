package persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Prerequisito;

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
		return em.find(prerequisito.getClass(), prerequisito.getId());
	}

	@Override
	public void update(EntityManager em, Prerequisito prerequisito) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(prerequisito);
		tx.commit();
	}

}
