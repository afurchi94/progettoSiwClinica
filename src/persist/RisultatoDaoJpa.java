package persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Risultato;

public class RisultatoDaoJpa implements RisultatoDao{

	@Override
	public void save(EntityManager em, Risultato risultato) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(risultato);
		tx.commit();
	}

	@Override
	public void delete(EntityManager em, Risultato risultato) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(risultato);
		tx.commit();
		
	}

	@Override
	public Risultato find(EntityManager em, Risultato risultato) {
		return em.find(risultato.getClass(), risultato.getId());
	}

	@Override
	public void update(EntityManager em, Risultato risultato) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(risultato);
		tx.commit();
		
	}

}
