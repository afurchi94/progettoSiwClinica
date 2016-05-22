package persist;

import java.util.List;

import javax.persistence.EntityManager;

import model.Amministrazione;

public interface AmministrazioneDao {
	public void save(EntityManager em, Amministrazione amministrazione);

	public void delete(EntityManager em, Amministrazione amministrazione);
	//mi puzza visto che la classe è singleton.
	public Amministrazione find(EntityManager em, Amministrazione amministrazione);

	public void update(EntityManager em, Amministrazione amministrazione);

}
