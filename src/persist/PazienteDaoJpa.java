package persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Paziente;

public class PazienteDaoJpa implements PazienteDao {

	@Override
	public void save(EntityManager em, Paziente paziente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(paziente);
		tx.commit();
	}

	@Override
	public void delete(EntityManager em, Paziente paziente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(paziente);
		tx.commit();
	}

	@Override
	public Paziente find(EntityManager em, Paziente paziente) {
		return em.find(paziente.getClass(), paziente.getId());
	}

	@Override
	public void update(EntityManager em, Paziente paziente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(paziente);
		tx.commit();

	}

	@Override
	public List<Paziente> findAll(EntityManager em) {
		return em.createNamedQuery("findAllPazienti").getResultList();
	}

}
