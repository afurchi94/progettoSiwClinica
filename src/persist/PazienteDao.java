package persist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Paziente;

public interface PazienteDao {
	public void save(EntityManager em,Paziente paziente);

	public void delete(EntityManager em, Paziente paziente);

	public Paziente find(EntityManager em, Paziente paziente);

	public void update(EntityManager em, Paziente paziente);

	public List<Paziente> findAll(EntityManager em);
}
