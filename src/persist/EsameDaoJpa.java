package persist;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;

import model.Esame;

public class EsameDaoJpa implements EsameDao {

	@Override
	public void save(EntityManager em, Esame esame) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(esame);
		tx.commit();
	}

	@Override
	public void delete(EntityManager em, Esame esame) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(esame);
		tx.commit();
	}

	@Override
	public Esame find(EntityManager em, Esame esame) {
		return em.find(esame.getClass(), esame.getId());
	}

	@Override
	public void update(EntityManager em, Esame esame) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(esame);
		tx.commit();

	}

	@Override
	public List<Esame> findAll(EntityManager em) {
		return em.createNamedQuery("findAllEsami").getResultList();
	}

}
