package persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.TipologiaEsame;

public class TipologiaEsameDaoJpa implements TipologiaEsameDao {

	@Override
	public void save(EntityManager em, TipologiaEsame tipologia) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(tipologia);
		tx.commit();
	}

	@Override
	public void delete(EntityManager em, TipologiaEsame tipologia) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(tipologia);
		tx.commit();
	}

	@Override
	public TipologiaEsame find(EntityManager em, TipologiaEsame tipologia) {
		return em.find(tipologia.getClass(), tipologia.getCodice());
	}

	@Override
	public void update(EntityManager em, TipologiaEsame tipologia) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(tipologia);
		tx.commit();

	}

	@Override
	public List<TipologiaEsame> findAll(EntityManager em) {
		return em.createNamedQuery("findAllTipologie").getResultList();
	}

}
