package persist;

import java.util.List;

import javax.persistence.EntityManager;


import model.TipologiaEsame;

public interface TipologiaEsameDao {
	public void save(EntityManager em,TipologiaEsame tipologia);

	public void delete(EntityManager em, TipologiaEsame tipologia);

	public TipologiaEsame find(EntityManager em, TipologiaEsame tipologia);

	public void update(EntityManager em, TipologiaEsame tipologia);

	public List<TipologiaEsame> findAll(EntityManager em);
}
