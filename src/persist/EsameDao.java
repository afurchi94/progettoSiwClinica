package persist;

import javax.persistence.EntityManager;
import model.Esame;
import java.util.List;

public interface EsameDao {
	public void save(EntityManager em, Esame Esame);

	public void delete(EntityManager em, Esame Esame);

	public Esame find(EntityManager em, Esame Esame);

	public void update(EntityManager em, Esame Esame);

	public List<Esame> findAll(EntityManager em);
}
