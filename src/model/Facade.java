package model;

import persist.PazienteDaoJpa;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.*;
import javax.ejb.*;
import persist.*;

//@Stateless(name="facade")
public class Facade {
	Clinica clinica;
	// @PersistenceContext(unitName = "clinicaAcme-unit-tomee")

	public Facade() {
		this.clinica = new Clinica();
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

	public void inserimentoTipologiaEsame(TipologiaEsame tipologia, Long codicePrerequisito, Risultato risultato) {
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
		prerequisito.addTipologiaEsame(tipologia);
		tipologia.addRisultato(risultato);
		// inserimento tipologia esame

		TipologiaEsameDaoJpa tipologiaDao = new TipologiaEsameDaoJpa();
		tipologiaDao.save(em, tipologia);

		em.close();
		emf.close();
	}

	public Amministratore loginAmministrazione(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		AmministratoreDaoJpa amministrazioneDao = new AmministratoreDaoJpa();
		Amministratore amministratore = new Amministratore();
		amministratore.setUsername(username);

		amministratore = amministrazioneDao.find(em, amministratore);
		if (amministratore != null)
			if (amministratore.checkPassword(password))
				return amministratore;

		return null;
	}

	public Paziente loginPaziente(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		Paziente paziente = new Paziente();
		paziente.setUsername(username);

		paziente = pazienteDao.find(em, paziente);
		if (paziente != null)
			if (paziente.checkPassword(password))
				return paziente;

		return null;
	}

	
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
	EntityManager em = emf.createEntityManager();
	
	em.close();
	emf.close();
}
}
