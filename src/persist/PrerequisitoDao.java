package persist;

import javax.persistence.EntityManager;

import model.Prerequisito;

public interface PrerequisitoDao {
	public void save(EntityManager em, Prerequisito prerequisito);

	public void delete(EntityManager em, Prerequisito prerequisito);

	public Prerequisito find(EntityManager em, Long id);

	public void update(EntityManager em, Prerequisito prerequisito);

}
