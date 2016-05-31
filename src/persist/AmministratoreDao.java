package persist;

import java.util.List;

import javax.persistence.EntityManager;

import model.Amministratore;

public interface AmministratoreDao {
	public void save(EntityManager em, Amministratore amministratore);

	public void delete(EntityManager em, Amministratore amministratore);

	public Amministratore find(EntityManager em, Amministratore amministratore);

	public void update(EntityManager em, Amministratore amministratore);

}
