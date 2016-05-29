package model;
import persist.PazienteDaoJpa;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.*;
import javax.ejb.*;

@Stateless(name="facade")
public class Facade {
	
	//@PersistenceContext(unitName = "clinicaAcme-unit-tomee")
	

	public Facade(){
		
	}
	public void inserisciPaziente(Paziente paziente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		pazienteDao.save(em,paziente);
		em.close();
		emf.close();
		
		
		
	}

}
