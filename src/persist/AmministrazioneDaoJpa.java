package persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Amministrazione;

public class AmministrazioneDaoJpa implements AmministrazioneDao {

	@Override
	public void save(EntityManager em, Amministrazione amministrazione) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(amministrazione);
		tx.commit();

	}

	@Override
	public void delete(EntityManager em, Amministrazione amministrazione) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(amministrazione);
		tx.commit();

	}
	//mi puzza visto che la classe è singleton.
	@Override
	public Amministrazione find(EntityManager em, Amministrazione amministrazione) {
		return em.find(amministrazione.getClass(), amministrazione.getCodice());
	}

	@Override
	public void update(EntityManager em, Amministrazione amministrazione) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(amministrazione);
		tx.commit();


	}

	

}
