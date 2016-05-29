package persist;

import javax.persistence.EntityManager;
import model.Risultato;


public interface RisultatoDao {
	public void save(EntityManager em, Risultato risultato);

	public void delete(EntityManager em, Risultato risultato);

	public Risultato find(EntityManager em, Risultato risultato);

	public void update(EntityManager em, Risultato risultato);
}
