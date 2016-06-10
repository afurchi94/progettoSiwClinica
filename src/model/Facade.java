package model;

import persist.PazienteDaoJpa;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.*;
import javax.ejb.*;

import persist.*;

import java.util.*;
import java.time.*;

@Stateless(name="facade")
public class Facade {
	private Clinica clinica;
	private TipologiaEsame tipologiaCorrente;
	private Medico medicoCorrente;
	private Paziente pazienteCorrente;
	private Esame esameCorrente;
	private Amministratore amministratoreCorrente;
	// @PersistenceContext(unitName = "clinicaAcme-unit-tomee")

	public Facade() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		this.clinica = new Clinica(em);
		em.close();
		emf.close();
	}




	public List<Esame> getEsami(){
		return this.clinica.getEsami();
	}
	public List<Medico> getMedici(){
		return this.clinica.getMedici();
	}
	public List<Paziente> getPazienti(){
		return this.clinica.getPazienti();
	}
	public List<TipologiaEsame> getTipologieEsame(){
		return this.clinica.getTipologieEsame();
	}
	
	
	
	public void inserisciRisultatiEsame(List<Risultato> risultati){
		this.esameCorrente.setRisultati(risultati);
	}

	public Medico selezionaMedico(String codice){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		Medico m= this.clinica.cercaMedico(em, codice);
		this.medicoCorrente=m;
		em.close();
		emf.close();
		return m;
	}

	public Esame scegliEsame(String codice) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		Esame e= this.clinica.cercaEsame(em,codice);
		this.esameCorrente=e;
		em.close();
		emf.close();
		return e;
	}




	public void inserisciDatiEsame(String tipo, String codFisc, Date dataE, String codMedico ){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		TipologiaEsame t= clinica.cercaTipologia(em,tipo);
		this.tipologiaCorrente=t;
		Medico m= clinica.cercaMedico(em,codMedico);
		this.medicoCorrente=m;
		Paziente p= clinica.cercaPaziente(em,codFisc);
		this.pazienteCorrente=p;


		Esame esame= new Esame();
		
		esame.setDataEffettuazione(dataE);
		esame.setPaziente(p);
		esame.setMedico(m);
		esame.setTipologia(t);
		LocalDate data= java.time.LocalDate.now() ;
		Date dataP= Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
		esame.setDataPrenotazione(dataP);

		EsameDaoJpa esameDao = new EsameDaoJpa();
		esameDao.save(em, esame);
		this.esameCorrente=esame;
		em.close();
		emf.close();
	}


	public void confermaInserimentoEsame(){


		this.esameCorrente.aggiungiPrenotazioneAPaziente();

	}

	public TipologiaEsame scegliTipologiaEsame(String codiceTipologia){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		TipologiaEsame t = this.clinica.cercaTipologia(em,codiceTipologia);
		this.tipologiaCorrente=t;
		em.close();
		emf.close();

		return t;
	}


	public void inserisciPaziente(Paziente paziente) {
		this.pazienteCorrente=paziente;
	}

	public void confermaInserimentoPaziente(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		this.clinica.creaPaziente(em, this.pazienteCorrente);
		em.close();
		emf.close();
	}

	public void autenticazioneAmministrazione() {
		// TODO Auto-generated method stub

	}

	public void inserisciTipologiaEsame(TipologiaEsame tipologia, List<String> risultati, List <String> preRequisiti) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		// ricerca prerequisito tramite nome
		List<Prerequisito> listReq=null;
		for(String s: preRequisiti){
			Prerequisito p=new Prerequisito();
			p.setNome(s);
			PrerequisitoDaoJpa pDaoJpa= new PrerequisitoDaoJpa();
			Prerequisito preRequisito= pDaoJpa.find(em, p);
			listReq.add(preRequisito);
		}

		// salvataggio del risultato nel database.


		List<Risultato> listRis=null;
		for(String s : risultati){
			Risultato r=new Risultato();
			r.setNome(s);
			RisultatoDaoJpa risultatoDao = new RisultatoDaoJpa();
			risultatoDao.save(em, r);
			listRis.add(r);
		}

		// aggiunta del prerequisito alla tipologia di esame

		tipologia.setPrerequisiti(listReq);
		tipologia.setRisultati(listRis);
		// inserimento tipologia esame

		this.clinica.creaTipologia(em, tipologia);

		em.close();
		emf.close();
	}

	public Amministratore loginAmministrazione(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		Amministratore amministratore = this.clinica.cercaAmministratore(em,username);
		if (amministratore != null)
			if (amministratore.checkPassword(password)){
				em.close();
				emf.close();
				this.amministratoreCorrente=amministratore;
				return amministratore;
			}
		em.close();
		emf.close();
		return null;
	}

	public Paziente loginPaziente(String codiceFiscale, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		Paziente paziente = this.clinica.cercaPaziente(em,codiceFiscale);
		if (paziente != null)
			if (paziente.checkPassword(password)){
				em.close();
				emf.close();
				this.pazienteCorrente=paziente;
				return paziente;
			}
		em.close();
		emf.close();
		return null;
	}


	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}
}
