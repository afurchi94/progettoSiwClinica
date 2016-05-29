package model;

import persist.PazienteDaoJpa;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.*;
import javax.ejb.*;
import persist.*;

//@Stateless(name="facade")
public class Facade {

	// @PersistenceContext(unitName = "clinicaAcme-unit-tomee")

	public Facade() {

	}

	public void inserisciPaziente(Paziente paziente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		pazienteDao.save(em, paziente);
		em.close();
		emf.close();

	}

	public void autenticazioneAmministrazione() {
		// TODO Auto-generated method stub

	}

	public void inserimentoTipologiaEsame(TipologiaEsame tipologia,Long codicePrerequisito, Risultato risultato) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		// ricerca prerequisito tramite codice
		PrerequisitoDaoJpa prerequisitoDao = new PrerequisitoDaoJpa();
		Prerequisito prerequisito = prerequisitoDao.find(em, codicePrerequisito);

		// salvataggio del risultato nel database.

		RisultatoDaoJpa risultatoDao = new RisultatoDaoJpa();
		risultatoDao.save(em, risultato);

		// aggiunta del prerequisito alla tipologia di esame

		tipologia.addPrerequisito(prerequisito);
		tipologia.addRisultato(risultato);
		// inserimento tipologia esame
		
		TipologiaEsameDaoJpa tipologiaDao = new TipologiaEsameDaoJpa();
		tipologiaDao.save(em, tipologia);
		
		em.close();
		emf.close();
	}

}
