package persist;

import java.util.List;

import javax.persistence.EntityManager;
import model.Medico;

public interface MedicoDao {
	public void save(EntityManager em, Medico medico);

	public void delete(EntityManager em, Medico medico);

	public Medico find(EntityManager em, Medico medico);

	public void update(EntityManager em, Medico medico);

	public List<Medico> findAll(EntityManager em);
}
