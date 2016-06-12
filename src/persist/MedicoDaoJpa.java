package persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Medico;

public class MedicoDaoJpa implements MedicoDao {

	@Override
	public void save(EntityManager em, Medico medico) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(medico);
		tx.commit();

	}

	@Override
	public void delete(EntityManager em, Medico medico) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(medico);
		tx.commit();

	}

	@Override
	public Medico find(EntityManager em, Medico medico) {
		return em.find(medico.getClass(), medico.getCodice());
	}

	@Override
	public void update(EntityManager em, Medico medico) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(medico);
		tx.commit();
	}

	@Override
	public List<Medico> findAll(EntityManager em) {
		return em.createNamedQuery("findAllMedici").getResultList();
	}

}
